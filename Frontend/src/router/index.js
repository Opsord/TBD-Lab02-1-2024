import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import PortalView from '../views/PortalView.vue';
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
      path: '/portal',
      name: 'portal',
      component: PortalView
    },
    {
      path: '/registrar-emergencia',
      name: 'Registrar emergencia',
      component: CrearEmergenciaView,

    },
    {
      path: '/emergencias-activas',
      name: 'Emergencias activas',
      component: VerEmergenciaView,
    },
    {
      path: '/emergencias-finalizadas',
      name: 'Emergencias finalizadas',
      component: VerEmergenciaFinalizadaView,
    }
  ]
})

export default router
