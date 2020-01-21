# HandlerDemo

基于这篇[博客](https://blog.csdn.net/tgvincent/article/details/808000)中Demo学习handler机制，研究原理

Interpolator 的系统值有下面几个：
<img src="https://wiki.jikexueyuan.com/project/android-animation/images/6.png" />

意义如下：

AccelerateDecelerateInterpolator 在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
AccelerateInterpolator 在动画开始的地方速率改变比较慢，然后开始加速
AnticipateInterpolator 开始的时候向后然后向前甩
AnticipateOvershootInterpolator 开始的时候向后然后向前甩一定值后返回最后的值
BounceInterpolator 动画结束的时候弹起
CycleInterpolator 动画循环播放特定的次数，速率改变沿着正弦曲线
DecelerateInterpolator 在动画开始的地方快然后慢
LinearInterpolator 以常量速率改变
OvershootInterpolator 向前甩一定值后再回到原来位置
