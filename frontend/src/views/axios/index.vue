<template>
  <div :style="{padding: '50px'}">
    <a-row :style="{textAlign: 'center'}">
      <a-button type="primary" @click="get1" :style="{margin: '0 20px'}">Get-1</a-button>
      <a-button type="primary" @click="get2" :style="{margin: '0 20px'}">Get-2</a-button>
      <a-button type="primary" @click="get3" :style="{margin: '0 20px'}">Get-3</a-button>
      <a-button type="primary" @click="get4" :style="{margin: '0 20px'}">Get-4</a-button>
      <a-button type="primary" @click="get5" :style="{margin: '0 20px'}">Get-5</a-button>
      <a-button type="primary" @click="get6" :style="{margin: '0 20px'}">Get-6</a-button>
    </a-row>
    <br/><br/>
    <a-row :style="{textAlign: 'center'}">
      <a-button type="primary" @click="post1" :style="{margin: '0 20px'}">Post-1</a-button>
      <a-button type="primary" @click="post2" :style="{margin: '0 20px'}">Post-2</a-button>
      <a-button type="primary" @click="post3" :style="{margin: '0 20px'}">Post-3</a-button>
      <a-button type="primary" @click="post4" :style="{margin: '0 20px'}">Post-4</a-button>
      <a-button type="primary" @click="post5" :style="{margin: '0 20px'}">Post-5</a-button>
    </a-row>
    <br/><br/>
    <a-row :style="{textAlign: 'center'}">
      <a-col :span="6"/>
      <a-col :span="12">
        <a-textarea
          v-model="response"
          :rows="6"
          :disabled="true"
        />
      </a-col>
      <a-col :span="6"/>
    </a-row>
  </div>
</template>

<script>
import {get1, get2, get3, get4, get5, get6} from "@/api/test/getAPI";
import {post1, post2, post3, post4, post5} from "@/api/test/postAPI";

export default {
  name: "index",
  data() {
    return {
      response: ''
    }
  },
  methods: {
    get1() {
      const _id = '123'
      get1(_id).then(res => {
        this.response = res.data
      })
    },
    get2() {
      const _id = '123'
      get2(_id).then(res => {
        this.response = res.data
      })
    },
    get3() {
      get3().then(res => {
        this.response = res.data
      })

    },
    get4() {
      get4().then(res => {
        this.response = res.data
      })
    },
    get5() {
      get5().then(res => {
        this.response = res.data
      })
    },
    get6() {
      get6().then(res => {
        this.response = res.data
      })
    },
    post1() {
      post1().then(res => {
        this.response = res.data
      })
    },
    post2() {
      post2().then(res => {
        this.response = res.data
      })
    },
    post3() {
      post3().then(res => {
        this.response = res.data
      })
    },
    post4() {
      post4().then(res => {
        this.response = res.data
      })
    },
    post5() {
      post5().then(res => {
        this.response = res.data
      })
    }
  }
}
</script>
