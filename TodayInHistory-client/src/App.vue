<script setup>
import {ref} from 'vue'
import axios from "axios";

const today = ref("")

const date = ref({
  month: 1,
  day: 1
})

let month = 1;
let day = 1;

const cx = () => {
  axios.get('http://localhost:8080/search/today_in_history', {
    params: {
      month: date.value.month,
      day: date.value.day
    }
  }).then(function (response) {
    today.value = response.data.data
    month = date.value.month
    day = date.value.day
  }).catch(function (error) {
    console.log(error);
  })
}

cx()
</script>

<template>
  <div class="bd-header">
    <div class="bd-top-header"><a><img src="./assets/img/logo-s.png" alt="通晓查询" title="通晓查询"></a></div>
  </div>
  <div class="position"><a>通晓查询</a> &gt; <a>历史上的今天</a>
  </div>
  <div class="bd-box">
    <div class="bd-row">
      <div class="bd-row-left">
        <div class="bd-row-block">
          <div class="bd-row-content center">
            <form>
              <p>
                <i class="f16">历史上的今天：</i>
                <select id="y_month" name="y_month" v-model="date.month">
                  <option value="1">01</option>
                  <option value="2">02</option>
                  <option value="3">03</option>
                  <option value="4">04</option>
                  <option value="5">05</option>
                  <option value="6">06</option>
                  <option value="7">07</option>
                  <option value="8">08</option>
                  <option value="9">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                </select> 月 <select id="y_day" name="y_day" v-model="date.day">
                <option value="1">01</option>
                <option value="2">02</option>
                <option value="3">03</option>
                <option value="4">04</option>
                <option value="5">05</option>
                <option value="6">06</option>
                <option value="7">07</option>
                <option value="8">08</option>
                <option value="9">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
              </select> 日
                <input class="search-btn ml5" type="button" name="submit" value="查询" @click="cx">
              </p>
            </form>
          </div>
        </div>
        <div class="bd-row-content">
          <h2>历史上的今天</h2>
          <div class="block-img-left center"><img class="wh60" src="./assets/img/jintian.png" title="历史上的今天"
                                                  alt="历史上的今天">
          </div>
          <div class="block-content-right">
            <p>
              历史上的今天可查询历史上国内外的今天{{ month }}月{{
                day
              }}日发生了什么大事要事，从古代到近代、现代、当代的一些人和物、国家、科学、政治、军事、文化、艺术、人文等相关的大小事、历史事件记录按月和日查询历史{{
                month
              }}月{{ day }}日的今天发生了什么事等。
            </p>
          </div>
        </div>
        <div class="bd-row-content zaoju-li">
          <h2>历史上的今天 {{ month }}月{{ day }}日</h2>
          <p v-for="item in today" :key="item.id"><span>{{ item.year }}年{{ item.month }}月{{ item.day }}日</span> <a class="ml20"
                                                                                    target="_blank">{{ item.data }}</a>
          </p>
        </div>
      </div>
    </div>
  </div>
  <div class="bd-footer"> ©2024 通晓查询 历史上的今天</div>
</template>

