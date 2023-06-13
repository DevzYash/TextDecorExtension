# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.yash.labeldecor.LabelDecor {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/yash/labeldecor/repack'
-flattenpackagehierarchy
-dontpreverify
