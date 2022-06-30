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
            >공지사항 수정
          </h3></b-alert
        >
      </b-col>
    </b-row>
    <notice-write-form type="modify" />
  </b-container>
</template>

<script>
import NoticeWriteForm from "./child/NoticeWriteForm.vue";

export default {
  name: "NoticeUpdate",
  components: {
    NoticeWriteForm,
  },
};
</script>

<style></style>
