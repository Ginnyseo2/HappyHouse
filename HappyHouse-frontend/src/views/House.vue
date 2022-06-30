<template>
  <b-container class="bv-example-row mt-3 text-center">
    <b-col style="padding: 0px">
      <b-alert show style="background-color: #a3e1ff"
        ><h4>
          <span
            ><b-icon
              style="margin: 0px 20px 0px 10px"
              icon="house-door-fill"
              font-scale="1.5"
            ></b-icon>
            아파트 정보</span
          >
        </h4>
      </b-alert>
    </b-col>
    <b-row style="margin-bottom: 40px">
      <b-col>
        <house-search-bar></house-search-bar>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <kakao-map></kakao-map>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="6" align="left">
        <house-list />
      </b-col>
      <b-col cols="6">
        <house-detail />
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseDetail from "@/components/house/HouseDetail.vue";
import KakaoMap from "@/components/house/KakaoMap.vue";
export default {
  name: "House",
  components: {
    HouseSearchBar,
    HouseList,
    HouseDetail,
    KakaoMap,
  },
};
</script>
<style scoped>
.underline-orange {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(231, 149, 27, 0.3) 30%
  );
}
</style>
