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
            >공지사항<b-button
              variant="outline-primary"
              @click="moveWrite()"
              class="float-right"
              >글쓰기</b-button
            >
          </h3></b-alert
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col v-if="articles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>제목</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <notice-list-row
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import NoticeListRow from "@/components/notice/child/NoticeListRow";
import { listArticle } from "@/api/notice.js";

export default {
  name: "NoticeList",
  components: {
    NoticeListRow,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 20,
      key: null,
      word: null,
    };
    listArticle(
      param,
      (response) => {
        console.log("공지사항 데이터", response.data);
        this.articles = response.data.articles;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "NoticeWrite" });
    },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
