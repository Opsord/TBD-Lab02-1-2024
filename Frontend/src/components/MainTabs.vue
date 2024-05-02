<template>
    <CoordinatorTabs v-if="store.role === 'COORDINATOR'"/>
    <VolunteerTabs v-else-if="store.role === 'VOLUNTEER'"/>
</template>

<script setup>
import CoordinatorTabs from '../components/CoordinatorTabs.vue';
import VolunteerTabs from '../components/VolunteerTabs.vue';
import { store } from '@/store';
</script>