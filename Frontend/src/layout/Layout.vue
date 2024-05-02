<template>
    <div v-if="role === 'VOLUNTEER'">
        <VolunteerTabs />
    </div>
    <div v-else-if="role === 'COORDINATOR'">
        <CoordinatorTabs />
    </div>
</template>

<script setup>
import { jwtDecode } from 'jwt-decode';
import { store } from '@/store';
import { onMounted, ref } from 'vue';
import axios from 'axios';
import CoordinatorTabs from '@/components/CoordinatorTabs.vue';
import VolunteerTabs from '@/components/VolunteerTabs.vue';

const role = ref(null);

async function fetchUserRole() {
    const decodedRut = jwtDecode(store.token.token).sub;
    console.log("RUT USUARIO: ", decodedRut);
    
    try {
        const response = await axios.get(`http://localhost:8090/api/users/rut/${decodedRut}`, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        console.log("Rol usuario obtenido correctamente", response.data.role);
        role.value = response.data.role;
    } catch (error) {
        console.log("Ha ocurrido un error al obtener el rol de usuario", error);
    }
}

onMounted(fetchUserRole);
</script>