<template>
  <b-container class="bv-example-row mt-3 text-center">
    <b-row>
      <b-col>
        <b-alert show style="background-color: #a3e1ff"
          ><h4>
            <span
              ><b-icon
                style="margin: 0px 20px 0px 10px"
                icon="newspaper"
                font-scale="1.5"
              ></b-icon>
              최신 부동산 뉴스</span
            ><b-button variant="outline-info" class="btn float-right"
              ><a
                href="https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EB%B6%80%EB%8F%99%EC%82%B0"
                target="_blank"
                rel="noreferrer noopener"
                >더보기</a
              ></b-button
            >
          </h4>
        </b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right"> </b-col>
    </b-row>
    <b-row>
      <b-col v-if="articles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>언론사</b-th>
              <b-th class="text-left">기사 제목</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <!-- <news-list-row
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            /> -->
            <news-list-row
              v-for="(article, index) in articles"
              :key="index"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
      <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
    </b-row>
  </b-container>
</template>

<script>
import NewsListRow from "@/components/news/child/NewsListRow";
import { listArticle } from "@/api/news.js";

export default {
  name: "NewsList",
  components: {
    NewsListRow,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 7,
      key: null,
      word: null,
    };
    listArticle(
      param,
      (response) => {
        console.log("뉴스 응답 : ", response);
        this.articles = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {},
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
