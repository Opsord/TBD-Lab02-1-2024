<script setup>
import './assets/base.css';
import NavBar from './components/NavBar.vue';
import Layout from './layout/Layout.vue';
import { store } from './store';
</script>

<template>
    <NavBar />
    <div v-if="store.token !== null">
        <Layout />
    </div>
    <RouterView />
</template>
