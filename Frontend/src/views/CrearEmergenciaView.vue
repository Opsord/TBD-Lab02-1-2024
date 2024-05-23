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
import DialogMap from "@/components/DialogMap.vue";


const markerPosition = ref(null);
const handleSaveMarker = (newMarkerPosition) => {
    markerPosition.value = newMarkerPosition;
    console.log('Parent marker position:', markerPosition.value);
    formModel.value.location.latitude = markerPosition.value.position.lat
    formModel.value.location.longitude = markerPosition.value.position.lng
};

const formModel = ref({
    title: '',
    status: false,
    description: '',
    coordinator: '',
    location: {
        latitude: 0,
        longitude: 0,
    }
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
        console.log("TERMINADO - Get atributos: ", response.data);
        attributes.value = response.data;
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

async function createEmergency(emergency) {
    try {
        const user = await fetchUserRole();
        emergency.coordinator = user.rut;

        const response = await axios.post(`http://localhost:8090/emergencies/create`, emergency, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        console.log("TERMINADO - Crear Emergencia: ", response.data);
        return response.data.id_emergency;

    } catch (err) {
        console.log(err)
    }
}

async function createEmergencyAttribute(idEmergencia) {
    console.log("ID emergencia: ", idEmergencia)
    const newModel = habilidadModel.value.map(habilidad => {
        return { ...habilidad, idEmergency: idEmergencia }
    })
    console.log("Nuevo modelo", newModel);

    try {
        const response = await axios.post(`http://localhost:8090/emergencyAttribute/createVarious`, newModel, {
            headers: {
                Authorization: `Bearer ${store.token.token}`
            }
        });
        console.log("Emergencia-Atributo: ", response.data);
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
    <div class="flex justify-center">
        <div class="rounded-lg border border-slate-200 bg-white text-slate-950 shadow-sm w-6/12 my-4 p-10">
            <form class="grid grid-cols-2 gap-10" @submit="onSubmit">
                    <FormField name="titulo">
                        <FormItem>
                            <FormLabel>Titulo</FormLabel>
                            <FormControl>
                                <Input type="text" placeholder="Titulo de la Emergencia" v-model="formModel.title" />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    </FormField>
                    <FormField name="descripcion">
                        <FormItem>
                            <FormLabel>Descripción</FormLabel>
                            <FormControl>
                                <Input type="text" placeholder="Descripción" v-model="formModel.description" />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    </FormField>
                <div class="space-y-3">
                    <p class="text-sm font-medium">Habilidades disponibles</p>
                    <ScrollArea class="h-[200px] w-full">
                        <div class="space-y-2" v-if="attributes && attributes.length">
                            <li class="flex gap-2 items-center text-sm" v-for="data in attributes.filter(item => !habilidadModel.some(seleccionado => seleccionado.attribute_id === item.attribute_id))"
                                :key="data.attribute_id">
                                <Button type="button"
                                    v-on:click="habilidadModel.push({ attribute_id: data.attribute_id, compatibility: 1 })">
                                    ✅
                                </Button>
                                <Button type="button"
                                    v-on:click="habilidadModel.push({ attribute_id: data.attribute_id, compatibility: 0 })">
                                    ❌
                                </Button>
                                <div>
                                    {{ data.attribute }}
                                </div>
                            </li>
                        </div>
                    </ScrollArea>
                </div>
                <div class="space-y-3">
                    <p class="text-sm font-medium">Habilidades seleccionadas</p>
                    <div class="flex">
                        <ScrollArea class="h-[200px] w-full">
                            <div class="space-y-2" v-if="habilidadModel && habilidadModel.length">
                                <li class="flex gap-2 items-center text-sm" v-for="data in habilidadModel" :key="data.attribute_id">
                                    <Button type="button" v-on:click="habilidadModel.pop(this)">
                                        ❌
                                    </Button>
                                    {{ attributes[data.attribute_id - 1].attribute }}
                                    <p v-if="data.compatibility === 1" class="text-green-600">&nbsp;Compatible</p>
                                    <p v-else-if="data.compatibility === 0" class="text-red-600">&nbsp;Incompatible</p>
                                </li>
                            </div>
                        </ScrollArea>
                    </div>
                </div>
                <DialogMap @save-marker="handleSaveMarker" />
                <div></div>
                <div>
                    <FormField name="activa" type="checkbox" v-model="formModel.status">
                        <FormItem class="flex items-end flex-row-reverse justify-end gap-4">
                            <FormLabel>¿Marcar como activa?</FormLabel>
                                <FormControl>
                                    <Checkbox id="disponibilidad" :checked="formModel.status"
                                        @update:checked="value => formModel.status = value" class="bg-slate-100 flex" />
                                </FormControl>
                            <FormMessage />
                        </FormItem>
                    </FormField>
                </div>
                <div class="flex justify-center col-span-2">
                    <Button variant="ghost" class="w-1/3 border border-zinc-600" type="button" v-on:click="onSubmit()">
                        Enviar
                    </Button>
                </div>
            </form>
        </div>
    </div>
</template>