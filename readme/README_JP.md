# プロジェクト概要
Toast APIを調査するためのプロジェクトです。

# 開発環境
<img width="686" alt="127751156-0638bd97-e532-43e9-be12-e758a7118141" src="https://user-images.githubusercontent.com/16476224/128230885-30d23c7f-5714-4590-9592-ec3f733b39e0.png">

# 結論 (代替案)

Toastは[makeText](https://developer.android.com/reference/kotlin/android/widget/Toast?hl=ja#maketext) で作成するテキスト トーストを使うか、
アプリがフォアグランド時のみ表示できる [Snackbar](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar) を使う。

# [Toastの動作変更点 OS:11](https://developer.android.com/about/versions/11/behavior-changes-11?hl=ja#toasts)

Android 11をターゲット & OS11以降の端末では、カスタムトーストを表示する場合、アプリがバックグランドの時はトーストの表示がブロックされる.<br>
[makeText](https://developer.android.com/reference/kotlin/android/widget/Toast?hl=ja#maketext) で作成するテキストのみの表示は引き続きバックグランドの時でも表示が可能。

[Toast APIの変更点](https://developer.android.com/about/versions/11/behavior-changes-11?hl=ja#text-toast-api-changes) の通り、
Android 11をターゲット & OS11以降の端末の場合、テキスト　トーストを使っていてもGravityの設定などは無効になった

# Toastの動作変更点 OS:12
- Toastに入れるテキストメッセージは最大で２行までで。それ以上を超える場合は通知を使うことを検討してください<br>
  - https://youtu.be/D2cU_itNDAI?t=714

- Toastの表示数に制限をかけた。 <br>理由としては今までは、Toastが重なって例えば50件連続で表示してしまった場合、<br>現在表示中のToast表示が終了するまで次のToastは待たないといけなく、画面上にToastが留まって見えるのでユーザー操作の邪魔になっていた。<br>
  -  https://youtu.be/D2cU_itNDAI?t=727

# Capture (Android View)

| Pixel 4 OS10 | Pixel 4 OS11 |
|:---|:---:|
| <img src="https://user-images.githubusercontent.com/16476224/117284945-5f325080-aea2-11eb-8278-c68feb8765a6.gif" width=320 /> | <img src="https://user-images.githubusercontent.com/16476224/117284926-58a3d900-aea2-11eb-9179-1294d8b03caf.gif" width=320 /> |

# Capture (Compose)

| Pixel 4 OS: 8 | Pixel 4 OS: 12 |
|:---|:---:|
| <img src="https://user-images.githubusercontent.com/16476224/151012930-1a1b1253-a715-4a35-abee-cc08a73c9b8a.gif" width=320 /> | <img src="https://user-images.githubusercontent.com/16476224/151012648-6a99b81d-0cd2-4bf4-9d6c-b05ab34a4ad6.gif" width=320 /> |

# For Compose
https://github.com/LeoAndo/android-toast-samples/tree/main/ToastComposeSample

# For Kotlin code
https://github.com/LeoAndo/android-toast-samples/tree/main/ToastKotlinSample

# For Java code
https://github.com/LeoAndo/android-toast-samples/tree/main/ToastJavaSample
