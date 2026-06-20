@Component
export struct EnablementItem {
  @Prop enablementItem: ArticleClass;
  build() {
    Row() {  // 改为横向排列
      // 图片区域（左侧）
      Image(this.enablementItem.imageSrc)
        .width(120)
        .height(120)
        .objectFit(ImageFit.Cover)
        .borderRadius(8)
      // 文字区域（右侧）
      Column() {
        Text(this.enablementItem.title)
          .fontSize(16)
          .fontWeight(FontWeight.Medium)
          .margin({ bottom: 4 })
          .maxLines(2)
          .textOverflow({ overflow: TextOverflow.Ellipsis })

        Text(this.enablementItem.brief)
          .fontSize(14)
          .fontColor('#99000000')
          .maxLines(3)
          .textOverflow({ overflow: TextOverflow.Ellipsis })
      }
      .padding({ left: 12 })
      .layoutWeight(1)  // 使文字区域填满剩余空间
    }
    .width('100%')
    .height(120)
    .padding(8)
    .backgroundColor(Color.White)
    .borderRadius(12)
    .margin({ bottom: 12 })
  }
}
@Entry
@Component
struct EnablementView{
  @State enablementList: Array<ArticleClass>=[
    new ArticleClass('1',$r('app.media.p1'),'冬至',
      '微信号：sadawdsadaw'),

  ];
  build() {
    Column(){
      Text('我的')
        .fontColor('#182431')
        .fontSize(16)
        .fontWeight(500)
        .fontFamily('HarmonyHeiTi-medium')
        .textAlign(TextAlign.Start)
        .padding({left:16})
        .margin({bottom:8.5})
      Grid(){
        ForEach(this.enablementList,(item:ArticleClass)=>{
          GridItem(){
            EnablementItem({enablementItem: item})
          }
        },(item:ArticleClass)=>item.id)
      }
      .rowsTemplate('1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr')
      .columnsGap(20)
      .scrollBar(BarState.Off)
      .height(1000)
      .padding({top:2,left:16,right:16})
    }
  }
}
@Component
export struct Mine{
  @State message:string='我的'
  build() {
    Column(){
      Text(this.message)
        .fontSize(24)
        .fontWeight(700)
        .width('100%')
        .textAlign(TextAlign.Start)
        .padding({left: 16})
        .fontFamily('HarmonyHeiTi-Bold')
        .lineHeight(33)
      Scroll(){
        Column(){
          EnablementView()
        }
      }
      .layoutWeight(1)
      .scrollBar(BarState.Off)
      .align(Alignment.TopStart)
    }
    .height("100%")
    .width('100%')
    .backgroundColor('#F1F3F5')
  }
}
class BannerClass{
  id: string='';
  imageSrc: ResourceStr='';
  constructor(id: string,imageSrc: ResourceStr) {
    this.id=id;
    this.imageSrc=imageSrc;
  }
}
export class ArticleClass{
  id: string='';
  imageSrc: ResourceStr='';
  title: string='';
  brief: string='';
  constructor(id:string,imageSrc: ResourceStr,title:string,brief: string) {
    this.id=id;
    this.imageSrc=imageSrc;
    this.title=title;
    this.brief=brief
  }
}
