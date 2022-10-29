<template>
  <div :style="{padding: '50px'}">
    <a-row :style="{textAlign: 'center'}">
      <a-button type="primary" @click="getOperation('get1')" :style="{margin: '0 20px'}">Get-1</a-button>
      <a-button type="primary" @click="getOperation('get1_1')" :style="{margin: '0 20px'}">Get-1-1</a-button>
      <a-button type="primary" @click="getOperation('get2')" :style="{margin: '0 20px'}">Get-2</a-button>
      <a-button type="primary" @click="getOperation('get3')" :style="{margin: '0 20px'}">Get-3</a-button>
      <a-button type="primary" @click="getOperation('get4')" :style="{margin: '0 20px'}">Get-4</a-button>
    </a-row>
    <br/><br/>
    <a-row :style="{textAlign: 'center'}">
      <a-button type="primary" @click="postOperation('post1')" :style="{margin: '0 20px'}">Post-1</a-button>
      <a-button type="primary" @click="postOperation('post2')" :style="{margin: '0 20px'}">Post-2</a-button>
      <a-button type="primary" @click="postOperation('post3')" :style="{margin: '0 20px'}">Post-3</a-button>
      <a-button type="primary" @click="postOperation('post4')" :style="{margin: '0 20px'}">Post-4</a-button>
      <a-button type="primary" @click="postOperation('post5')" :style="{margin: '0 20px'}">Post-5</a-button>
      <a-button type="primary" @click="postOperation('post6')" :style="{margin: '0 20px'}">Post-6</a-button>
      <a-button type="primary" @click="postOperation('post7')" :style="{margin: '0 20px'}">Post-7</a-button>
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
import {get1, get1_1, get2, get3, get4} from "@/api/test/getAPI";
import {post1, post2, post3, post4, post5, post6, post7} from "@/api/test/postAPI";

export default {
  name: "index",
  data() {
    return {
      response: ''
    }
  },
  methods: {
    async getOperation(type) {
      let _params = {}
      let _student = {}
      this.$message.info(type)
      switch (type) {
        case 'get1':
          await get1('123').then(res => {
            this.response = res.data
          })
          break
        case 'get1_1':
          _params = {
            id: '123'
          }
          await get1_1(_params).then(res => {
            this.response = res.data
          })
          break
        case 'get2':
          _params = {
            id: '123'
          }
          await get2(_params).then(res => {
            this.response = res.data
          })
          break
        case 'get3':
          _params = {
            id: '123',
            message: 'hello'
          }
          await get3(_params).then(res => {
            this.response = res.data
          })
          break
        case 'get4':
          _student = {
            id: '123',
            name: 'alex',
            score: 0
          }
          await get4(_student).then(res => {
            this.response = res.data
          })
          break
      }
      console.log(type, this.response)
    },
    // ----------------------------
    async postOperation(type) {
      let _params = {}
      let _student = {}
      let _teacher = {}
      this.$message.info(type)
      switch (type) {
        case 'post1':
          _params = {
            id: '123'
          }
          await post1(_params).then(res => {
            this.response = res.data
          })
          break
        case 'post2':
          _params = {
            id: '123'
          }
          await post2(_params).then(res => {
            this.response = res.data
          })
          break
        case 'post3':
          _params = {
            id: '123',
            message: 'hello'
          }
          await post3(_params).then(res => {
            this.response = res.data
          })
          break
        case 'post4':
          _student = {
            id: '123',
            name: 'alex',
            score: 0
          }
          await post4(_student).then(res => {
            this.response = res.data
          })
          break
        case 'post5':
          _student = {
            id: '123',
            name: 'alex',
            score: 0
          }
          await post5(_student).then(res => {
            this.response = res.data
          })
          break
        case 'post6':
          _params = {
            id: '123'
          }
          _teacher = {
            id: '456',
            name: 'alex'
          }
          await post6(_params, _teacher).then(res => {
            this.response = res.data
          })
          break
        case 'post7':
          _student = {
            id: '123',
            name: 'alex',
            score: 80
          }
          _teacher = {
            id: '456',
            name: 'beth'
          }
          await post7(_student, _teacher).then(res => {
            this.response = res.data
          })
          break
      }
      console.log(type, this.response)
    }
  }
}
</script>
