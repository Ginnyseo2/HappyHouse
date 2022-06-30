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
            >공지사항 작성
          </h3></b-alert
        >
      </b-col>
    </b-row>
    <notice-write-form type="register" />
  </b-container>
</template>

<script>
import NoticeWriteForm from "./child/NoticeWriteForm.vue";

export default {
  name: "NoticeWrite",
  components: {
    NoticeWriteForm,
  },
};
</script>

<style></style>
