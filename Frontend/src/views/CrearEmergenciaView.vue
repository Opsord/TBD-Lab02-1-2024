<script setup>
import {
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage
} from '@/components/ui/form'
import { Input } from '@/components/ui/input'
import { Checkbox } from '@/components/ui/checkbox';
import { Button } from '@/components/ui/button';
import ScrollArea from '@/components/ui/scroll-area/ScrollArea.vue';
import { store, fetchUserRole } from '@/store';
import axios from 'axios'
import { ref, onMounted } from 'vue'

const formModel = ref({
    title: '',
    status: false,
    description: '',
    /* coordinator: '' */
});

const habilidadModel = ref([])

const attributes = ref(null)

async function fetchAttributes() {
    try {
        const response = await axios.get(`http://localhost:8090/attributes/all`, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        attributes.value = response.data;
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

async function createEmergency(emergency) {
    try {
        const user = await fetchUserRole();
        emergency.coordinator = user.rut;
        console.log("Emergency: ", emergency);

        const response = await axios.post(`http://localhost:8090/emergencies/create`, emergency, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });

        console.log(response.data);
        return response.data.idEmergency;

    } catch (err) {
        console.log(err)
    }
}

async function createEmergencyAttribute(idEmergencia) {
    console.log(idEmergencia)
    const newModel = habilidadModel.value.map(habilidad => {
        return { ...habilidad, idEmergency: idEmergencia }
    })
    console.log("Nuevo modelo". newModel);
    
    try {
        const response = await axios.get(`http://localhost:8090/emergencyAttribute/createVarious`, newModel, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        return response.data

    } catch (err) {
        console.log(err)
    }
}

onMounted(fetchAttributes);

async function onSubmit() {
    const idEmergencia = await createEmergency(formModel.value)
    const atributosCreados = await createEmergencyAttribute(idEmergencia)
}

</script>
<template>
    <div class="flex align-middle items-center justify-center mt-4 ">
        <form class=" space-y-4 flex flex-col" @submit="onSubmit">
            <FormField name="titulo">
                <FormItem>
                    <FormLabel>Titulo:</FormLabel>
                    <FormControl>
                        <Input type="text" placeholder="Titulo de la Emergencia" v-model="formModel.title" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>
            <FormField name="descripcion">
                <FormItem>
                    <FormLabel>Descripción:</FormLabel>
                    <FormControl>
                        <Input type="text" placeholder="Descripción" v-model="formModel.description" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>
            <h1>Habilidades de los voluntarios actuales:</h1>
            <div>
                <ScrollArea class="h-[150px] w-[400px]">
                    <div v-if="attributes && attributes.length">
                        <li v-for="data in attributes.filter(item => !habilidadModel.some(seleccionado => seleccionado.idAttribute === item.idAttribute))"
                            :key="data.idAttribute">
                            {{ data.attribute }}
                            <Button type="button"
                                v-on:click="habilidadModel.push({ idAttribute: data.idAttribute, compatibility: 1 })">
                                ✅
                            </Button>
                            <Button type="button"
                                v-on:click="habilidadModel.push({ idAttribute: data.idAttribute, compatibility: 0 })">
                                ❌
                            </Button>
                        </li>
                    </div>
                </ScrollArea>
            </div>
            <h1>Habilidades seleccionadas:</h1>
            <div>
                <ScrollArea class="h-[200px] w-[400px]">
                    <div v-if="habilidadModel && habilidadModel.length">
                        <li v-for="data in habilidadModel" :key="data.idAttribute">
                            {{ attributes[data.idAttribute - 1].attribute }}
                            <p v-if="data.compatibility === 0" class="text-red-400">&nbsp;Incompatible
                            </p>
                            <Button type="button" v-on:click="habilidadModel.pop(this)">
                                ❌
                            </Button>
                        </li>
                    </div>
                </ScrollArea>
            </div>
            <FormField name="activa" type="checkbox" v-model="formModel.status">
                <FormItem class="flex flex-row items-center align-middle space-x-2">
                    <FormLabel>¿Marcar como activa?</FormLabel>
                    <FormControl>
                        <Checkbox id="disponibilidad" :checked="formModel.status"
                            @update:checked="value => formModel.status = value" class="bg-slate-100 flex" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>
            <Button variant="ghost" class="border border-zinc-600" type="button" v-on:click="onSubmit()">
                Enviar
            </Button>   
        </form>
    </div>
</template>
