<template>
  <div>
    <div>
      <div class="aboutWrapper">
        <div class="aboutContainer">
          <!-- About Title -->
          <div style="display: flex">
            <div class="descAbout">
              <div class="titleAbout">ABOUT</div>
              <span>HappyHouse 웹 사이트는 <br /><br /></span>
              <span
                >고객이 원하는 주택 정보를 조회할 수 있도록 하고, <br /><br
              /></span>
              <span
                >그 결과를 분석해서 해당 정보와 함께 지도를 보여줍니다.
                <br /><br
              /></span>
              <span
                >또한 관심지역의 상가에 대한 조회및 환경 정보 등을 추가적으로
                제공합니다.</span
              >
            </div>
            <div>
              <img
                class="happyHouseImg"
                alt="HappyHoused 이미지"
                src="@/assets/img/AboutHappyHouse.jpg"
              />
            </div>
          </div>
          <div class="titleDev">DEVELOPERS</div>
          <div style="display: flex">
            <div class="developer">
              <div>
                <img alt="" src="@/assets/img/ssafy_geuntae.jpg" width="300" />
              </div>
              <div class="aboutDev">
                <div>
                  <span style="font-weight: bolder">김근태</span
                  ><span>학번 : 0619717</span>
                </div>
                <div>
                  <span style="font-style: italic"
                    >당당한 백엔드 개발자가 되고 싶어요.</span
                  >
                </div>
                <div>
                  <span>이메일 : dsw00513@naver.com</span>
                </div>
                <div>
                  <span>깃헙 : github.com/damwon</span>
                </div>
              </div>
            </div>
            <div class="developer">
              <div>
                <img alt="" src="@/assets/img/ssafy_seoyejin.jpg" width="300" />
              </div>
              <div class="aboutDev">
                <div>
                  <span style="font-weight: bolder">서예진</span
                  ><span>학번 : 0611513</span>
                </div>
                <div>
                  <span style="font-style: italic"
                    >백엔드 개발자가 되고 싶어요 :)</span
                  >
                </div>
                <div>
                  <span>이메일 : jasmin960427@naver.com</span>
                </div>
                <div>
                  <span>깃헙 : github.com/jasmin</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "About",
};
</script>

<style scoped>
.aboutWrapper {
  display: flex;
  margin: auto;
  width: fit-content;
}
.aboutContainer {
  width: 100%;
}
.developer {
  display: flex;
}
.developer > div > img {
  margin-left: -25px;
}

.titleAbout {
  font-size: xx-large;
  font-weight: 700;
  margin: 70px 0px 50px 0px;
}
.titleDev {
  font-size: xx-large;
  font-weight: 700;
  margin: 0px 0px 10px 0px;
}
.descAbout {
  margin-top: 30px;
}
.descAbout > span {
  font-size: 18px;
}

.aboutDev {
  margin: 0px 70px;
}
.aboutDev > div {
  margin: 45px 0px;
}
.aboutDev > div > span {
  font-size: 20px;
  margin: 0px 20px;
}

.happyHouseImg {
  margin: 10px 0px 0px 150px;
  width: 550px;
}
</style>
