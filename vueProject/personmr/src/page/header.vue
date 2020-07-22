<!--头部（Header.vue）-->
<template>
  <div>
    <div class="topbar-logo topbar-btn">
      <img src="../../static/image/logo.png" width="40px" height="40px" >
    </div>
    <div class="topbar-title topbar-btn">
      <span>后台管理系统</span>
    </div>
    <div class="topbar-account topbar-btn">
      <el-dropdown trigger="click">
       <img src="../../static/image/admin.png" width="40px" height="40px" >
      </el-dropdown>
    </div>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    data() {
      return {
        sysUserName: '',
        sysUserAvatar: '',
        collapsed: false,
      }
    },
    mounted() {
      var userSession = this.getCookie('session');
      if(userSession) {
        this.sysUserName = userSession || '';
      }
    },
    methods: {
      //退出
      logout() {
        this.$confirm('确认要退出吗？','提示',{}).then(() => {
          this.$fetch('m/logout').then((res) =>{
            if(res.errCode == 200) {
              this.delCookie('session');
              this.delCookie('u_uuid');
              this.$router.push({path: '/', query: {redirect: this.$router.currentRoute.fullPath}});
            } else {
              console.log(res.errMsg);
            }
          });
        }).catch(() => {
        });
      },
      //个人信息
      userinfo() {
        this.$router.push('/userinfo');
      },
      //修改密码
      editpwd() {
        this.$router.push('/editpwd');
      }
    }
  }
</script>
<style lang="less">
	@import '../style/mixin';
	.header_container{
		background-color: #EFF2F7;
		height: 60px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-left: 20px;
	}
	.avator{
		.wh(36px, 36px);
		border-radius: 50%;
		margin-right: 37px;
	}
	.el-dropdown-menu__item{
        text-align: center;
    }
</style>