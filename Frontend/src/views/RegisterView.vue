<template>
    <div class="flex flex-col gap-8 mx-auto my-16 w-4/12">
        <div class="flex justify-center">
            <h2 class=" text-lg font-bold text-teal-600">¿Quieres formar parte de nosotros?</h2>
        </div>
        <div class="w-full p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Llena el siguiente formulario</h2>
            <form>
                <div class="grid gap-5 grid-cols-2">
                    <div class="flex flex-col gap-2">
                        <label for="nombre" class="text-sm">Nombre</label>
                        <Input v-model="nombre" type="text" placeholder="Nombre usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="apellido" class="text-sm">Apellido</label>
                        <Input v-model="apellido" type="text" placeholder="Apellido usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="email" class="text-sm">Correo electrónico</label>
                        <Input v-model="email" type="email" placeholder="usuario@email.com" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="contrasena" class="text-sm">Contraseña</label>
                        <Input v-model="contrasena" type="password" placeholder="********" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="rut" class="text-sm">RUT</label>
                        <Input v-model="rut" type="text" placeholder="12.345.678-9" />
                    </div>
                    <div class="grid grid-cols-2 gap-3  ">
                        <div class="flex flex-col gap-2">
                            <label for="edad" class="text-sm">Edad</label>
                            <select v-model="edad" class="px-3 py-2 border border-gray-400 rounded text-sm"
                                required>
                                <option value="">Edad</option>
                                <option v-for="edad in edades" :key="edad" :value="edad">{{ edad }}</option>
                            </select>
                        </div>
                        <div class="flex flex-col gap-2">
                            <label for="sexo" class="text-sm">Sexo</label>
                            <select v-model="sexo" class="px-3 py-2 border border-gray-400 rounded text-sm"
                                required>
                                <option value="">Sexo</option>
                                <option :value="true">Masculino</option>
                                <option :value="false">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="flex items-end gap-6">
                        <label for="disponibilidad" class="w-full text-sm">¿Estás disponible?</label>
                        <div class="flex items-center space-x-2">
                            <input v-model="disponibilidad" type="radio" name="disponibilidad" :value="true" required>
                            <label for="disponibilidadsi" class="text-sm">Sí</label>
                        </div>
                        <div class="flex items-center space-x-2">
                            <input v-model="disponibilidad" type="radio" name="disponibilidad" :value="false" required>
                            <label for="disponibilidadno" class="text-sm">No</label>
                        </div>
                    </div>
                    <ButtonPrimary @click="registerUser" buttonText="Registrarse" />
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import axios from 'axios';
import ButtonPrimary from '../components/ButtonPrimary.vue';
import Input from "../components/Input.vue";

const router = useRouter();
const nombre = ref("");
const apellido = ref("");
const email = ref("");
const contrasena = ref("");
const rut = ref("");
const edad = ref("");
const sexo = ref("");
const disponibilidad = ref("");
const edades = ref([]);

for (let i = 18; i <= 60; i++) {
    edades.value.push(i);
}

const registerUser = async () => {
    const data = {
        rut: rut.value,
        nombreVoluntario: nombre.value,
        apellidoVoluntario: apellido.value,
        edadVoluntario: edad.value,
        sexoVoluntario: sexo.value,
        email: email.value,
        contrasena: contrasena.value,
        disponibilidad: disponibilidad.value,
        role: "VOLUNTARIO"
    }

    console.log("Voluntario")
    console.log(data);

    try {
        const response = await axios.post('http://localhost:8090/volunteers/create', data);
        console.log(response.data);
        redirectToLogin();
    } catch (error) {
        console.log("Error al registar un nuevo voluntario", error);
    }
}

const redirectToLogin = () => {
    console.log("Redirigiendo a /");
    router.push('/');
}
</script>