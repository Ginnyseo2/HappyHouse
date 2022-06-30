<template>
  <b-tr>
    <b-td>{{ articleno }}</b-td>
    <b-th class="text-left">
      <router-link
        :to="{ name: 'NoticeView', params: { articleno: articleno } }"
        >{{ subject }}</router-link
      >
    </b-th>
    <b-td>{{ regTime }}</b-td>
  </b-tr>
</template>

<script>
// import moment from "moment";

export default {
  name: "NoticeListRow",
  data() {
    return {
      arno: null,
    };
  },
  mounted() {
    // console.log("article: ", this.articleno);
  },
  props: {
    articleno: Number,
    subject: String,
    regTime: String,
    //content: String,
  },
};
</script>

<style></style>
