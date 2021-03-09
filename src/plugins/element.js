import Vue from 'vue'
import {
  Form, FormItem, Input, Button, Row, Col, Container, Image, Header, Carousel,
  CarouselItem, Rate, Progress, Divider, Message, Collapse, CollapseItem, Avatar, Pagination, Tabs, TabPane, Menu, MenuItem
} from 'element-ui'
import CollapseTransition from 'element-ui/lib/transitions/collapse-transition'

Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(Button)
Vue.use(Row)
Vue.use(Col)
Vue.use(Container)
Vue.use(Image)
Vue.use(Header)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Rate)
Vue.use(Progress)
Vue.use(Divider)
Vue.use(FormItem)
Vue.use(Collapse)
Vue.use(CollapseItem)
Vue.use(Avatar)
Vue.use(Pagination)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Menu)
Vue.use(MenuItem)

Vue.prototype.$message = Message

Vue.component(CollapseTransition.name, CollapseTransition)
