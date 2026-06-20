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
    new ArticleClass('1',$r('app.media.p1'),'聊天人员1号',
      '基于真实的开发场景，提供向导式学习，多维度融合课程等内容，给开发者提供全新的学习体验。'),
    new ArticleClass('2',$r('app.media.p2'),'聊天人员2号',
      '提供系统能力概述、快速入门，用于指导开发者进行场景化的开发指南涉及到的知识点包括必要的背景知识、'+
        '符合开发者实际开发场景的操作任务流（开发流程、开发步骤、调测验证》以及常见问题等。',),
    new ArticleClass('3',$r('app.media.p3'),'聊天人员3号',
      '针对新发布特性及热点特性提供详细的技术解析和开发最佳实践。'),
    new ArticleClass('4', $r('app.media.p4'),'聊天人员4号',
      '以教学为目的的代码样例及详细的开发指导，帮助开发者一步步地完成指定场景的应用开发并掌握相关知识,CodeLabs将最新的鸿蒙生态应用开发技术与典型场景结合,'+
        '让开发者快速地掌握开发高质量应用的方法。同时支持互动式操作，通过文字、代码和效果联动为开发者带来更佳的学习体验。'),
    new ArticleClass('5',$r('app.media.p5'),'花开富贵',
      '面向不同类型的开发者提供的鸿蒙生态应用开发优秀实践，每个SampleCode都是一个可运行的工程，为开发者提供实例化的代码参考。'),
    new ArticleClass('6',$r('app.media.weixin'),'聊天人员6号',
      '面向开发者提供鸿蒙系统开放接口的全集，供开发者了解具体接口使用方法。API参考详细地描述了每个接口的功能、使用限制、参数名、参数类型、参数含义、取值范围、权限、注意事项、错误码及返回值等。'),
    new ArticleClass('7',$r('app.media.weixin'),'聊天人员7号',
      '开发者常见问题的总结，开发者可以通过FAQ更高效地解决常见问题。FAQ会持续刷新，及时呈现最新的常见问题。',),
    new ArticleClass('8',$r('app.media.weixin'),'聊天人员8号','和其他应用开发者交流技术、共同进步。'),
  ];
  build() {
    Column(){
      Text('聊天')
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
export struct Home{
  @State message:string='聊天'
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
