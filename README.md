# HandlerDemo

基于这篇[博客](https://blog.csdn.net/tgvincent/article/details/808000)中Demo学习handler机制，研究原理

通过xml来定义View动画涉及到一些公有的属性（在AndroidStudio上不能提示）：

```
android:duration     动画持续时间
android:fillAfter    为true动画结束时，View将保持动画结束时的状态
android:fillBefore   为true动画结束时，View将还原到开始开始时的状态
android:repeatCount  动画重复执行的次数
android:repeatMode   动画重复模式 ，重复播放时restart重头开始，reverse重复播放时倒叙回放，该属性需要和android:repeatCount一起使用
android:interpolator 插值器，相当于变速器，改变动画的不同阶段的执行速度
```

`Interpolator` 的系统值有下面几个：
<img src="https://wiki.jikexueyuan.com/project/android-animation/images/6.png" />

意义如下：

```
AccelerateDecelerateInterpolator 在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
AccelerateInterpolator 在动画开始的地方速率改变比较慢，然后开始加速
AnticipateInterpolator 开始的时候向后然后向前甩
AnticipateOvershootInterpolator 开始的时候向后然后向前甩一定值后返回最后的值
BounceInterpolator 动画结束的时候弹起
CycleInterpolator 动画循环播放特定的次数，速率改变沿着正弦曲线
DecelerateInterpolator 在动画开始的地方快然后慢
LinearInterpolator 以常量速率改变
OvershootInterpolator 向前甩一定值后再回到原来位置
```

参考：
[Interpolator 插值器](https://wiki.jikexueyuan.com/project/android-animation/2.html)
