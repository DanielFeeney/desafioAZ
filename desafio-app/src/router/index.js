import Vue from 'vue'
import VueRouter from 'vue-router'
import Listagem from '../views/Listagem.vue'
import Administrador from '../views/Administrador.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Listagem',
    component: Listagem
  },
  {
    path: '/Administrador',
    name: 'Administrador',
    component: Administrador
  }
]

const router = new VueRouter({
  routes
})

export default router
