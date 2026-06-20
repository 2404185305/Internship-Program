import { Home } from '../pages/Home';
import { Look } from '../pages/Look';
import { Main } from '../pages//Main';
import { Mine } from '../pages/Mine';
import { MyTaBar } from '../pages/MyTabBar';

@Entry
@Preview
@Component
struct Index {
  private tabsController: TabsController = new TabsController();
  @State private isShowToolSheet: boolean = false;
  @Provide('pageInfos') pageInfos: NavPathStack = new NavPathStack();

  @Builder
  build() {
    Navigation(this.pageInfos) {
      Flex({
        direction: FlexDirection.Column,
      }) {
        Tabs({}){
          TabContent(){
            Home()
          }
          TabContent(){
            Look()
          }
          TabContent(){
            Main()
          }
          TabContent(){
            Mine()
          }
        }
        .barHeight(0)
        .flexShrink(1)
        MyTaBar({
          itemChange: (index: number) =>{
            if (index ===2) {
              this.isShowToolSheet =true
            }else{
              this.tabsController.changeIndex(index)
            }
          }
        })
      }
      .backgroundColor('#FDFDFD')
    }
    .hideTitleBar(true)
    .hideToolBar(true)
  }
}
