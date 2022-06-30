<template>
  <b-container style="text-align: left">
    {{ codeToString }}

    <button
      class="seeBtn"
      v-if="this.isin == 'apt'"
      @click.prevent="showInterest"
    >
      보기
    </button>
    <button
      class="deleteBtn"
      v-if="this.isin == 'apt'"
      @click.prevent="deleteInterest"
    >
      삭제
    </button>
  </b-container>
</template>

<script>
import { convertCodeToString } from "../../api/member.js";
import { mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";
const memberStore = "memberStore";
export default {
  name: "MemberMyPagInterestRow",
  data() {
    return {
      codeToString: "",
    };
  },
  props: {
    area: String,
    isin: String,
  },
  created() {
    this.convertInterCodeToString();
  },
  methods: {
    ...mapActions(houseStore, ["getDBHouseList"]),
    ...mapMutations(memberStore, ["DELETE_AREA"]),
    //동코드를 글자로
    convertInterCodeToString() {
      //console.log(this.area);
      convertCodeToString(this.area, (response) => {
        this.codeToString = response.data;
      });
    },
    showInterest() {
      console.log("현재", this.area);
      this.getDBHouseList(this.area);
    },
    deleteInterest() {
      this.DELETE_AREA(this.area);
    },
  },
};
</script>

<style>
.seeBtn {
  margin: 0px 10px 10px 20px;
  font-weight: bold;
  text-decoration: none;
  font-family: Arial;
  box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 4px 0px;
  o-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 4px 0px;
  -moz-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 4px 0px;
  -webkit-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 4px 0px;
  background: #77b6d1;
  background: -o-linear-gradient(90deg, #77b6d1, #7acff4);
  background: -moz-linear-gradient(center top, #77b6d1 5%, #7acff4 100%);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #77b6d1),
    color-stop(1, #7acff4)
  );
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#77b6d1', endColorstr='#7acff4');
  background: -webkit-linear-gradient(#77b6d1, #7acff4);
  background: -ms-linear-gradient(#77b6d1, #7acff4);
  background: linear-gradient(#77b6d1, #7acff4);
  text-indent: 0px;
  line-height: 0px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  text-align: center;
  vertical-align: middle;
  display: inline-block;
  font-size: 12px;
  color: #395863;
  width: 63px;
  height: 0px;
  padding: 13px;
  text-shadow: #ade6ff 0px 1px 0px;
  border-color: #59a9c6;
  border-width: 1px;
  border-style: solid;
}
.seeBtn:active {
  box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 0 0px;
  o-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 0 0px;
  -moz-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 0 0px;
  -webkit-box-shadow: inset #ffffff 0px 1px 1px -1px, #4895b1 0px 0 0px;
  position: relative;
  top: 4px;
}

.seeBtn:hover {
  background: #7acff4;
  background: -o-linear-gradient(90deg, #7acff4, #77b6d1);
  background: -moz-linear-gradient(center top, #7acff4 5%, #77b6d1 100%);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #7acff4),
    color-stop(1, #77b6d1)
  );
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#7acff4', endColorstr='#77b6d1');
  background: -webkit-linear-gradient(#7acff4, #77b6d1);
  background: -ms-linear-gradient(#7acff4, #77b6d1);
  background: linear-gradient(#7acff4, #77b6d1);
}
.deleteBtn {
  margin: 0px 10px 10px 10px;
  font-weight: bold;
  text-decoration: none;
  font-family: Arial;
  box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 4px 0px;
  o-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 4px 0px;
  -moz-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 4px 0px;
  -webkit-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 4px 0px;
  background: #cf7676;
  background: -o-linear-gradient(90deg, #cf7676, #f27979);
  background: -moz-linear-gradient(center top, #cf7676 5%, #f27979 100%);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #cf7676),
    color-stop(1, #f27979)
  );
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#cf7676', endColorstr='#f27979');
  background: -webkit-linear-gradient(#cf7676, #f27979);
  background: -ms-linear-gradient(#cf7676, #f27979);
  background: linear-gradient(#cf7676, #f27979);
  text-indent: 0px;
  line-height: 0px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  text-align: center;
  vertical-align: middle;
  display: inline-block;
  font-size: 12px;
  color: #422828;
  width: 63px;
  height: 0px;
  padding: 13px;
  text-shadow: #ffadad 0px 1px 0px;
  border-color: #c45858;
  border-width: 1px;
  border-style: solid;
}

.deleteBtn:active {
  box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 0 0px;
  o-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 0 0px;
  -moz-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 0 0px;
  -webkit-box-shadow: inset #ffffff 0px 1px 1px -1px, #b04848 0px 0 0px;
  position: relative;
  top: 4px;
}

.deleteBtn:hover {
  background: #f27979;
  background: -o-linear-gradient(90deg, #f27979, #cf7676);
  background: -moz-linear-gradient(center top, #f27979 5%, #cf7676 100%);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    color-stop(0.05, #f27979),
    color-stop(1, #cf7676)
  );
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f27979', endColorstr='#cf7676');
  background: -webkit-linear-gradient(#f27979, #cf7676);
  background: -ms-linear-gradient(#f27979, #cf7676);
  background: linear-gradient(#f27979, #cf7676);
}
</style>
