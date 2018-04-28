import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import LeaderboardView from './components/LeaderboardView'
import LeaderboardCreate from './components/LeaderboardCreate'

Vue.use(VueRouter);
Vue.use(VueResource);

Vue.url.options.root = 'http://' + window.location.hostname + ':8888/api/';
Vue.config.productionTip = false;

const router = new VueRouter({
    routes: [{
        name: 'leaderboard-create',
        path: '/',
        component: LeaderboardCreate
    }, {
        name: 'leaderboard',
        path: '/leaderboard/:id',
        component: LeaderboardView
    }]
});

new Vue({
    router,
    render: createElement => createElement(App)
}).$mount('#app');
