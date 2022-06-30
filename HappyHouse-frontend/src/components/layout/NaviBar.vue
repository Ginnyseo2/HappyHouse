<template>
  <div>
    <nav class="navbar navbar-expand-sm px-5 py-5 bg shadow">
      <div class="container-fluid text-center navContent">
        <div class="collapse navbar-collapse Header" id="mynavbar">
          <ul class="navbar-nav fw-bold ms-sm-5 ps-sm-5">
            <!-- Home -->
            <router-link :to="{ name: 'Home' }" class="navbar-brand text-brand"
              >Happy<span class="color-a">House</span></router-link
            >
            <!-- About Us -->
            <li class="nav-item">
              <router-link :to="{ name: 'About' }" class="nav-link"
                >소개페이지</router-link
              >
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'Notice' }" class="nav-link">
                공지사항</router-link
              >
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'House' }" class="nav-link">
                아파트정보</router-link
              >
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'News' }" class="nav-link">
                부동산 뉴스</router-link
              >
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'Board' }" class="nav-link">
                Q&A 게시판</router-link
              >
            </li>
          </ul>
        </div>
      </div>
      <b-collapse id="nav-collapse" class="loginInfo" is-nav>
        <b-navbar-nav class="ml-auto" v-if="userInfo">
          <span class="align-self-center">
            {{ userInfo.username }}({{ userInfo.userid }})님 환영합니다.</span
          >
          <span class="align-self-center"
            ><router-link
              :to="{ name: 'MyPage' }"
              class="link align-self-center myInfo"
              >내정보보기</router-link
            ></span
          >
          <span
            class="link align-self-center logOutBtn"
            @click.prevent="onClickLogout"
            >로그아웃</span
          >
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto loginElse" v-else>
          <router-link :to="{ name: 'SignUp' }" class="link">
            회원가입</router-link
          >
          <router-link :to="{ name: 'SignIn' }" class="link">
            로그인</router-link
          >
        </b-navbar-nav>
      </b-collapse>
    </nav>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "NaviBar",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "Home" });
    },
  },
};
</script>

<style scoped>
.text-brand {
  margin: 0px 30px 0px 80px;
  font-size: 30px;
}
.Header > ul > li {
  padding-top: 5px;
  padding-right: 15px;
  font-size: 25px;
}
.navContent {
  display: contents;
}

.ml-auto > a {
  font-size: 20px;
  font-weight: 700;
  margin: 0px 15px;
}

.ml-auto > a,
.ml-auto > span > .myInfo {
  text-decoration: none;
  color: #e9ecef;
}
.navContent ul a {
  color: #e9ecef;
}

.navContent ul a.router-link-exact-active:not(.text-brand),
.ml-auto > span > .myInfo.router-link-exact-active,
.ml-auto > a.router-link-exact-active {
  color: #2d405c;
}
.bg {
  background: #63bce7;
}
.bg-other {
  background-color: #2a2a2a;
}
.ml-auto > span > .myInfo:hover,
ul a:hover {
  color: #2d405c;
}
.bg-brown {
  background-color: #2d405c;
}
.nav-link {
  font-weight: bold;
}
.dropDown {
  background-color: #a9a9a9;
}
.loginInfo {
  width: 1000px;
  margin-top: 5px;
}
.ml-auto {
  display: inline-block;
}
.ml-auto > span {
  margin-left: 25px;
  display: inline-block;
  color: black;
  font-weight: bold;
  width: auto;
}
.ml-auto > .myInfo,
.ml-auto > .logOutBtn {
  color: #e9ecef;
  cursor: pointer;
}
.logOutBtn:hover {
  color: #2d405c;
}
/*------/ Hamburger Navbar /------*/
.text-brand {
  color: #000000;
  font-size: 2rem;
  font-weight: 600;
}
/* @media (max-width: 575px) {
  nav > div :not(nav > div .text-brand) {
    display: none;
  }
  .text-brand {
    display: inline;
    font-size: 1rem;
  }
} */
.color-a {
  color: #2d405c;
}
@media (min-width: 1740px) and (max-width: 1860px) {
  .Header ul li {
    padding-top: 5px;
    padding-right: 15px;
    font-size: 20px;
  }
  .text-brand {
    margin-right: 20px;
    font-size: 30px;
  }
}
@media (min-width: 1520px) and (max-width: 1739px) {
  .Header ul li {
    padding-top: 5px;
    padding-right: 12px;
    font-size: 15px;
  }
  .text-brand {
    margin-right: 20px;
    font-size: 25px;
  }
}
@media (min-width: 767px) and (max-width: 1519px) {
  .Header ul li {
    padding-top: 5px;
    padding-right: 10px;
    font-size: 12px;
  }
  .text-brand {
    margin-right: 20px;
    font-size: 20px;
  }
}
@media (min-width: 576px) and (max-width: 767px) {
  .text-brand {
    display: block;
    font-size: 2.8rem;
  }
  .text-brand > span {
    display: flex;
  }
}
</style>
