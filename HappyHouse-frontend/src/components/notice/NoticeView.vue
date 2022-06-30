<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show style="background-color: #a3e1ff">
          <h3>
            <b-icon
              style="margin: 0px 20px 0px 10px"
              icon="card-list"
              font-scale="1.2"
            ></b-icon
            >공지사항
          </h3></b-alert
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="listArticle">목록</b-button>
      </b-col>
      <b-col class="text-right" v-if="loginid === 'admin'">
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          >글수정</b-button
        >
        <b-button variant="outline-danger" size="sm" @click="removeArticle"
          >글삭제</b-button
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.articleno}.
          ${article.subject}</h3><div><h6>${article.userid}</div><div>${article.regTime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import moment from "moment";
import { mapActions, mapState } from "vuex";
import { getArticle, deleteArticle } from "@/api/notice";
// import ReplyList from "../reply/ReplyList.vue";

const boardStore = "boardStore";
const memberStore = "memberStore";

export default {
  components: {},
  data() {
    return {
      article: {},
      loginid: "",
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
    message() {
      if (this.article.content)
        return this.article.content.split("\n").join("<br>");
      return "";
    },
    // changeDateFormat() {
    //   return moment(new Date(this.article.regtime)).format(
    //     "YYYY.MM.DD hh:mm:ss"
    //   );
    // },
  },
  created() {
    this.loginid = this.userInfo.userid;
    getArticle(
      this.$route.params.articleno,
      (response) => {
        this.article = response.data;
        console.log("유저인포: ", this.article);
      },
      (error) => {
        console.log("삭제 에러발생", error);
      }
    );
  },
  methods: {
    ...mapActions(boardStore, ["setUserid"]),
    // async saveUserid() {
    //   console("1111111111111111");
    //   await this.getUserid(this.article.userid);
    // },
    listArticle() {
      this.$router.push({ name: "NoticeList" });
    },
    async moveModifyArticle() {
      this.setUserid(this.article.userid);
      this.$router.replace({
        name: "NoticeUpdate",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    removeArticle() {
      if (confirm("정말 삭제 하시겠습니까?")) {
        deleteArticle(this.article.articleno, () => {
          this.$router.push({ name: "NoticeList" });
        });
      }
    },
  },
};
</script>

<style></style>
