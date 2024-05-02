import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import CrearEmergenciaView from '../views/CrearEmergenciaView.vue'
import VerEmergenciaView from '../views/VerEmergenciaView.vue';
import VerEmergenciaFinalizadaView from '../views/VerEmergenciaFinalizadaView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      path: '/registrar-emergencia',
      name: 'Registrar emergencia',
      component: CrearEmergenciaView,

    },
    {
      path: '/ver-emergencia',
      name: 'Emergencia activas',
      component: VerEmergenciaView,
    },
    {
      path: '/emergencias-finalizadas',
      name: 'Emergencia finalizadas',
      component: VerEmergenciaFinalizadaView,
    }
  ]
})

export default router
