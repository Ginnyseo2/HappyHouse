<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show style="background-color: #a3e1ff">
          <h3>
            <b-icon
              style="margin: 0px 20px 0px 10px"
              icon="chat-dots"
              font-scale="1.2"
            ></b-icon
            >Q&A 게시판<b-button
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
              <b-th>조회수</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <board-list-row
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>

    <b-button
      style="margin: -10px 40px 30px 0px"
      size="sm"
      variant="outline-dark"
      @click="prev()"
      v-if="pg != 1"
      >PREV</b-button
    >
    <span v-for="(page, index) in pages" :key="index">
      <b-button
        style="margin: -10px 0px 30px 0px"
        size="sm"
        variant="danger"
        v-if="page <= last && page == pg"
        @click="pageChange(page)"
      >
        {{ page }}
      </b-button>
      <b-button
        style="margin: -10px 0px 30px 0px"
        size="sm"
        v-if="page <= last && page != pg"
        @click="pageChange(page)"
        >{{ page }}</b-button
      >
    </span>
    <b-button
      style="margin: -10px 0px 30px 40px"
      size="sm"
      variant="outline-dark"
      @click="next()"
      v-if="pg != last"
      >NEXT</b-button
    >
  </b-container>
</template>

<script>
import BoardListRow from "@/components/board/child/BoardListRow";
import { listArticle, totalArticle } from "@/api/board.js";

export default {
  name: "BoardList",
  components: {
    BoardListRow,
  },
  data() {
    return {
      articles: [],
      pages: [],
      pg: 1,
      spp: 5,
      start: 1,
      end: this.start + this.spp - 1,
      last: null,
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 5,
      key: null,
      word: null,
    };
    listArticle(
      param,
      (response) => {
        console.log("qna 리스트 데이터", response.data);
        this.articles = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
    totalArticle(param, (response) => {
      console.log("토탈 아티클:", response);
      this.last = response.data;
      let pages = [];
      let start = (this.pg - 1) / 5 + 1;
      for (let i = start; i < start + 5; i++) {
        pages.push(i);
      }
      this.pages = pages;
    });
  },
  methods: {
    makePagenation() {
      let pages = [];
      let mod = this.pg % 5;
      if (mod == 0) mod = 5;
      let start = this.pg - mod + 1;
      for (let i = start; i < start + 5; i++) {
        pages.push(parseInt(i));
      }
      this.pages = pages;
    },
    moveWrite() {
      this.$router.push({ name: "BoardWrite" });
    },
    next() {
      this.start += this.spp;
      let param = {
        pg: ++this.pg,
        spp: this.spp,
        start: this.start,
        key: null,
        word: null,
      };
      listArticle(
        param,
        (response) => {
          this.articles = response.data;
          this.makePagenation();
          console.log(this.pg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    prev() {
      this.start -= this.spp;
      let param = {
        pg: --this.pg,
        spp: this.spp,
        start: this.start,
        key: null,
        word: null,
      };
      listArticle(
        param,
        (response) => {
          this.articles = response.data;
          this.makePagenation();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    pageChange(page) {
      this.start = this.spp * (page - 1) + 1;
      this.pg = page;
      console.log(this.pg);
      let param = {
        pg: page,
        spp: this.spp,
        start: this.start,
        key: null,
        word: null,
      };
      listArticle(
        param,
        (response) => {
          this.articles = response.data;
          this.makePagenation();
        },
        (error) => {
          console.log(error);
        }
      );
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
