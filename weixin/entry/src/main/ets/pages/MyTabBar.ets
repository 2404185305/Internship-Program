import {router} from "@kit.ArkUI"
interface BarItem{
  title: string
  icon: Resource
  selectedIcon: Resource}
@Preview
@Component
export struct MyTaBar{
  itemChange?:(index: number)=>void
  private barItemList: BarItem[] =[
    {
      'title': '微信',
      'icon':$r('app.media.weixin'),
      'selectedIcon': $r('app.media.touxiang')
    },
    {
      'title': '通讯录',
      'icon':$r("app.media.weixin"),
      'selectedIcon': $r("app.media.touxiang")
    },
    {
      'title': '发现',
      'icon':$r('app.media.weixin'),
      'selectedIcon': $r('app.media.touxiang')
    },
    {
      'title': '我的',
      'icon':$r("app.media.weixin"),
      'selectedIcon': $r("app.media.touxiang")
    },
  ];
  @State private currentSelected: number=0;
  build() {
    Flex() {
      ForEach(this.barItemList, (item: BarItem, index) => {
        Column() {
          Image(this.currentSelected === index ? item.selectedIcon : item.icon)
            .width(index != 2 ? 22 : 32)
            .height(index != 2 ? 22 : 32)
            .objectFit(ImageFit.Contain)
          if (index != 2) {
            Text(item.title)
              .fontColor(this.currentSelected === index ? '#1296db' : '#BFBFBF')
              .fontSize(8)
              .padding({
                top: 6
              })
          }
        }
        .width('100%')
        .justifyContent(FlexAlign.Center)
        .offset({
          top: index === 2 ? 4 : 0
        })
        .padding({
          top: index === 2 ? 0 : 6,
          bottom: index === 2 ? 0 : 0
        })
        .onClick(() => {
          if (index != 2) {
            this.currentSelected = index;
          }
          if (this.itemChange) {
            this.itemChange(index);
          }
          if(index===0){
            router.pushUrl({
              url: "pages/Home"
            })

          }
          if(index===1){
            router.pushUrl({
              url: "pages/Look"
            })
          }
          if(index===2){
            router.pushUrl({
              url: "pages/Main"
            })
          }
          if(index===3){
            router.pushUrl({
              url: "pages/Mine"
            })
          }



        });
      },
        (item: BarItem, index)=>{
          return `tabBarItem_${index}`
        })
    }
    .backgroundColor('#FFFFFF')
  }}