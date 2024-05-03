<template>
    <div class="flex justify-center items-center align-middle">
        <div v-if="emergencia && emergencia.length">
            <div v-for="data in emergencia" :key="data.emergencyId">
                <Card>
                    <CardHeader>
                        <CardTitle>{{ data.title }}</CardTitle>
                    </CardHeader>
                    <CardContent>
                        {{ data.description }}
                    </CardContent>
                    <CardFooter class=" whitespace-pre-line">
                        <p>Voluntarios registrados:</p>
                        <p v-for="voluntario in data.voluntarios" :key="voluntario">
                            &nbsp;
                            {{ voluntario.nombreVoluntario }} {{
                                voluntario.apellidoVoluntario }}
                        </p>
                    </CardFooter>
                </Card>
            </div>
        </div>
    </div>
</template>


<script setup>

import axios from 'axios'
import { ref, onMounted } from 'vue'
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "@/components/ui/card"
import { store } from '@/store';

const emergencia = ref(null)

async function fetchEmergencia() {
    try {
        const response = await axios.get(`http://localhost:8090/emergencies/active`, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        emergencia.value = response.data;
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

async function fetchVoluntarios() {
    if (emergencia.value && emergencia.value.length > 0) {
        console.log(emergencia.value);
        try {
            const fetchPromises = emergencia.value.map(async (emergenciaEach) => {
                const response = await axios.get(`http://localhost:8090/rankings/taskId/${emergenciaEach.idEmergency}`, {
                    headers: {
                        Authorization: `Bearer ${store.token.token}`
                    }
                });
                const rut = response.data.map(ranking => ranking.rut);
                return { ...emergenciaEach, ids: rut };
            });
            emergencia.value = await Promise.all(fetchPromises);
        } catch (error) {
            console.error('There was an error fetching the volunteers data:', error);
        }
    }
}

async function fetchVoluntariosData() {
    if (emergencia.value && emergencia.value.length > 0) {
        try {
            const fetchPromises = emergencia.value.map(async (emergenciaEach) => {
                ;
                const voluntarioPromises = emergenciaEach.ids.map(async (rut) => {
                    const response = await axios.get(`http://localhost:8090/api/users/rut/${rut}`, {
                        headers: {
                            Authorization: `Bearer ${store.token.token}`
                        }
                    })
                    return response.data
                })
                return { ...emergenciaEach, voluntarios: await Promise.all(voluntarioPromises) };
            });
            emergencia.value = await Promise.all(fetchPromises);
        } catch (error) {
            console.error('There was an error fetching the volunteers data:', error);
        }
    }
}

onMounted(async () => { await fetchEmergencia(); await fetchVoluntarios(); await fetchVoluntariosData() });

</script>