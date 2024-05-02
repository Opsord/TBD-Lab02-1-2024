<script setup>
import { jwtDecode } from 'jwt-decode';
import { store } from '@/store';
import { onMounted } from 'vue';
import axios from 'axios';
import router from '@/router';

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
        store.role = response.data.role;
        
        if (store.role === "COORDINATOR") {
            redirectToHomeCoordinator();
        } else if (store.role === "VOLUNTEER") {
            redirectToHomeVolunteer();
        }
    } catch (error) {
        console.log("Ha ocurrido un error al obtener el rol de usuario", error);
    }
}

const redirectToHomeVolunteer = () => {
    console.log("Redirigiendo a /emergencias-activas");
    router.push('/emergencias-activas');
}

const redirectToHomeCoordinator = () => {
    console.log("Redirigiendo a /registrar-emergencia");
    router.push('/registrar-emergencia');
}

onMounted(fetchUserRole);
</script>