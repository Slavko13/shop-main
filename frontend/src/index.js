// JS
import './js/'

// SCSS
import './assets/scss/main.scss'
import './assets/scss/authorization.scss'

import Vuelidate from 'vuelidate'

// CSS (example)
// import './assets/css/main.css'



// Vue.js
window.Vue = require('vue')
Vue.use(Vuelidate)
// Vue components (for use in html)
Vue.component('example-component', require('./js/components/Example.vue').default)
Vue.component('reg-components', require('./js/components/Register.vue').default)

// Vue init
const app = new Vue({
  el: '#app'
})
