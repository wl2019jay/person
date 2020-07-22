import Vue from 'vue'
import Vuex from 'vuex'
import {getAdminInfo} from '@/api/getData'
import {
	Editable,
	EditableColumn
  } from 'vue-element-extends'
import TreeTable from 'tree-table-vue-extend'
import 'vue-element-extends/lib/index.css'
import vuemoment  from 'vue-moment'
Vue.use(Vuex)
Vue.use(Editable)
Vue.use(EditableColumn)
Vue.use(TreeTable)
Vue.use(vuemoment)
const state = {
	adminInfo: {
		avatar: 'default.jpg'
	},
}

const mutations = {
	saveAdminInfo(state, adminInfo){
		state.adminInfo = adminInfo;
	}
}

const actions = {
	async getAdminData({commit}){
		try{
			const res = await getAdminInfo()
			if (res.status == 1) {
				commit('saveAdminInfo', res.data);
			}else{
				throw new Error(res.type)
			}
		}catch(err){
			// console.log(err.message)
		}
	}
}

export default new Vuex.Store({
	state,
	actions,
	mutations,
})
