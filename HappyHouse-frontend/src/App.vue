<template>
  <div id="app">
    <navi-bar />
    <router-view />
    <Footer />
    <back-to-top />
  </div>
</template>

<script>
import NaviBar from "./components/layout/NaviBar.vue";
import Footer from "./components/layout/Footer.vue";
import BackToTop from "./components/layout/BackToTop.vue";

export default {
  name: "App",
  components: {
    NaviBar,
    Footer,
    BackToTop,
  },
};
</script>

<style>
a:hover {
  text-decoration: none;
  font-weight: bold;
}
</style>
