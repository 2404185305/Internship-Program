import {ArticleClass } from "./Home";
@Component
export struct GrideItem{
  // private title: string = 'Harmonyos第一课'；
  //privatebrief：string＝「基于真实的开发场景，提供向导式学习，多维度融合课程等内容，给开发者提供全新的学习体验。';
  @Prop grideItem: ArticleClass;
  build() {
    Column() {
      Image(this.grideItem.imageSrc)
        .width('100%')
        .objectFit(ImageFit.Cover)
        .height(96)
        .borderRadius({
          topLeft: 16,
          topRight: 16
        })
      Text(this.grideItem.title)
        .height(19)
        .width('100%')
        .fontSize(14)
        .textAlign(TextAlign.Start)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .maxLines(1)
        .fontWeight(400)
        .padding({ left: 12, right: 12 })
        .margin({ top: 8 })
      Text(this.grideItem.brief)
        .height(32)
        .width('100%')
        .fontSize(12)
        .textAlign(TextAlign.Start)
        .textOverflow({ overflow: TextOverflow.Ellipsis })
        .maxLines(2)
        .fontWeight(400)
        .fontColor('rgba(0,0,0,0.6)')
        .padding({ left: 12, right: 12 })
        .margin({ top: 2 })

    }
    .width(160)
    .height(169)
    .borderRadius(16)
    .backgroundColor(Color.White)
  }
}
