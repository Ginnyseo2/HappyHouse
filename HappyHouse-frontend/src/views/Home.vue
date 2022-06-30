<template>
  <div class="Home">
    <img alt="" src="@/assets/img/adTest1.jpg" />
    <carousel
      :autoplay="true"
      :center="true"
      :dots="false"
      :items="1"
      :nav="false"
      :autoplayTimeout="2000"
      class="carouselCustom"
    >
      <img alt="" src="@/assets/img/slide-1.jpg" />

      <img alt="" src="@/assets/img/slide-2.jpg" />

      <img class="cover" alt="" src="@/assets/img/slide-3.jpg" />
    </carousel>
    <img alt="" src="@/assets/img/adTest2.png" />
  </div>
</template>

<script>
import carousel from "vue-owl-carousel";
export default {
  components: {
    carousel,
  },
  name: "Main",
  props: {
    msg: String,
  },
};
</script>

<style scoped>
.Home {
  display: flex;
}
.underline-steelblue {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(72, 190, 233, 0.3) 30%
  );
}
.carouselCustom {
  width: 1124px;
  margin: auto;
  object-fit: cover;
}
</style>
