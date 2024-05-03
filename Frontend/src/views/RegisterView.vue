<template>
    <div class="flex flex-col gap-8 mx-auto my-16 w-5/12">
        <div class="flex justify-center">
            <h2 class=" text-lg font-bold text-teal-600">¿Quieres formar parte de nosotros?</h2>
        </div>
        <div class="w-full p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Llena el siguiente formulario</h2>
            <form>
                <div class="grid gap-5 grid-cols-2">
                    <div class="flex flex-col gap-2">
                        <label for="rut" class="text-sm">RUT</label>
                        <Input v-model="rut" type="text" placeholder="12.345.678-9" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="password" class="text-sm">Contraseña</label>
                        <Input v-model="password" type="password" placeholder="********" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="name" class="text-sm">Nombre</label>
                        <Input v-model="name" type="text" placeholder="Nombre usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="lastname" class="text-sm">Apellido</label>
                        <Input v-model="lastname" type="text" placeholder="Apellido usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="email" class="text-sm">Correo electrónico</label>
                        <Input v-model="email" type="email" placeholder="usuario@email.com" />
                    </div>
                    <div class="flex justify-between gap-2">
                        <div class="flex flex-col gap-2 w-full">
                            <label for="birthdate" class="text-sm">Fecha de Nacimiento</label>
                            <Input v-model="birthdate" type="date" />
                        </div>
                        <div class="flex flex-col gap-2 w-full">
                            <label for="sexo" class="text-sm">Sexo</label>
                            <select v-model="sex" class="px-3 py-2.5 border border-gray-400 rounded text-sm" required>
                                <option value="">Sexo</option>
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="flex flex-col gap-2">
                        <select v-model="availability" class="px-3 py-2.5 border border-gray-400 rounded text-sm" required>
                            <option value="">Disponibilidad</option>
                            <option value="true">Si</option>
                            <option value="false">No</option>
                        </select>
                    </div>
                </div>
            </form>
            <div class="mt-4">
                <ButtonPrimary @click="registerUser" buttonText="Registrarse" />
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";
import axios from 'axios';
import ButtonPrimary from '../components/ButtonPrimary.vue';
import Input from "../components/Input.vue";

const router = useRouter();
const rut = ref("");
const email = ref("");
const name = ref("");
const lastname = ref("");
const birthdate = ref("");
const sex = ref("");
const password = ref("");
const availability = ref("");

const registerUser = async () => {
    const data = {
        rut: rut.value,
        email: email.value,
        name: name.value,
        lastName: lastname.value,
        birthDate: birthdate.value,
        sex: sex.value,
        password: password.value,
        role: "VOLUNTEER",
        availability: availability.value
    }
    try {
        console.log("Data antes axios: ", data);
        const response = await axios.post('http://localhost:8090/auth/register', data);
        console.log("Usuario registrado correctamente: ", response.data);
        redirectToLogin();
    } catch (error) {
        console.log("Error al registar un nuevo usuario", error);
    }
}

const redirectToLogin = () => {
    console.log("Redirigiendo a /");
    router.push('/');
}
</script>