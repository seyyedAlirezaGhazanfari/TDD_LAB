# محاسبه مساحت با ایجاد آزمون‌رانه (Test-driven Development)

در این مخزن برنامه ای برای محاسبه مساحت شکل‌های مستطیل و مربع به صورت TDD ایجاد شده است.
برای اینکار ابتدا تست‌های مربوط به توابع مورد نیاز پیاده سازی می‌شود و در مرحله اول تستی پاس نمی‌شود، سپس کدی که تست‌ها را پاس کند توسعه می‌یابد.

##  پرسش ها
### پرسش ۱
در چرخه‌ی عمومی ایجاد نرم‌افزار، آزمون نرم‌افزار بعد از پیاده‌سازی نرم‌افزار انجام می‌شود، اما در روش TDD ابتدا unit test ها و سپس کد برنامه را می‌نویسیم. آیا این دو مورد با هم تناقضی دارند؟
#### پاسخ:
خیر، در حالی که چرخه کلی توسعه نرم‌افزار شامل مراحل برنامه‌ریزی، تحلیل، طراحی، پیاده سازی، تست و استقرار و نگهداری است، TDD بر روی یک رویکرد خاص برای پیاده سازی و تست تمرکز دارد. TDD با تمرکز بر واحدهای کوچک و قابل آزمایش کد، یک رویکرد incremental و repeatative را ترویج می‌کند و کمک می کند تا اطمینان حاصل شود که کد به طور کامل مورد آزمون قرار گرفته است. در واقع TDD تکمیل کننده چرخه عمومی نرم‌افزار است و روشی agile و iterative برای توسعه ارائه می‌دهد. TDD ممکن است کمی توالی وظایف را در چرخه توسعه عمومی تغییر دهد، اما با آن تناقض ندارد و هدف آن پیاده‌سازی حداقلی و اطمینان بخش برای تحقق اهداف مورد نظر سیستم است (پس از پیاده‌سازی حداقلی ریفکتور کیفیت را بالا می‌برد).

### پرسش ۲
آزمون‌های واحد ریزدانه هستند. با بیان مثال، طیف آزمون‌ها بر اساس ریزدانگی یا درشت‌دانگی (granularity) را توضیح دهید.
### پاسخ:
منظور از test granularity همان ریزدانگی یا درشت‌دانگی در تمرکز تست است. این مفهموم تعیین می‌کند که یک تست چقدر جدا شده (در تعامل با یک تابع) و یا چقدر یکپارچه (در تعامل چند کلاس-تابع باشد). تست‌ها را از نظر granularity می‌توان در یک هرم در نظر گرفت بدین صورت که تست‌ها از ریز دانه به درشت دانه از پایه هرم به بالا مرتب می‌شوند و اندازه سطوح هرم نشانگر اهمیت و تعداد تست از آن نوع است. unit test ها که ریزدانه هستند بهتر است که بیشترین سهم از تست‌ها را تشکیل دهند چون سریع و کم هزینه هستند و هر چه به بالای هرم برویم تست ها پیچیده تر و پر هزینه تر و کند تر می‌شوند مثل integration testها و تست‌های manual و E2E.
<br/>
از تست‌های fine-graind می‌توان به تست‌های واحد اشاره کرد (unit test) که جدا شده (isolated) هستند و فقط یک بخش یا تابع به صورت منزوی مورد بررسی قرار می‌گیرد. وقتی در unit test به داده تابع ها و بخش های دیگر نیاز داریم از mock object های از پیش تعیین شده استفاده می‌کنیم تا رفتار تابع تحت تاثیر بخش های دیگر کد نباشد.
<br/>
در وسط هرم تست تست‌های integration قرار دارند. این تست ها درشت دانه تر از unit test بوده ولی ریزدانه تر از تست های manual و E2E هستند. در این مرحله تست‌ها چند ماژول یا فرایند را مورد بررسی قرار می‌دهند و درستی ارتباط بخش‌های مختلف کد نیز سنجیده می‌شود.
<br/>
در راس هرم تست‌های E2E - system testing - manual testing قرار می‌گیرند که coarse-grained حساب می‌شوند این تست ها غالبا کل فرایند سیستم نرم افزاری را مورد بررسی قرار می‌دهند و بر خلاف integration testing به یک فراینده یا پروسه خاص محدود نمی‌شوند.
<br/>
پ.ن۱: منظور از E2E تست‌های end-to-end است که کل سناریو های ممکن کاربر را شبیه سازی می‌کند. منظور از system testing تست کل سیستم که متشکل از integration های تست شده است به صورت جامع است.
<br/>
پ.ن۲: به صورت جزئی تر در راس هرم (ریز دانگی) به نیازمندی های نرم افزار نزدیک تر هستیم و traceback به آنها داریم و در تست های پایین هرم (درشت دانگی) traceback به طراحی برنامه داریم.

### پرسش ۳
آیا همه‌ی انواع آزمون‌های نرم‌افزار را برنامه‌نویسان ایجاد می‌کنند؟
### پاسخ:
خیر، تست‌های مختلفی هستند که توسط برنامه نویسان (نقش programmer) انجام نمی‌شوند.
به طور مثال تست‌های پذیرش (acceptance testing) معمولا توسط تحلیل گران یا کاربران نهایی طراحی و انجام می‌شوند. مثال دیگر نیز تست استفاده‌پذیری (usability testing) است که اندازه می‌گیرد چقدر کار با یک نرم افزار ساده و قابل فهم است. این تست ها نیز توسط برنامه نویسان طراحی نمی‌شود و بیشتر درگیری را ui/ux designer و یا کاربران نهایی با آن دارند.

### پرسش ۴
اصول SOLID در کدام یک از گام‌های اصلی ایجاد نرم‌افزار (تحلیل نیازمندی‌ها، طراحی، پیاده‌سازی، آزمون و استقرار) استفاده می‌شوند؟ توضیح دهید.
###
اصول SOLID در تمام گام‌های اصلی نرم افزار مهم هستند. این اصول باعث تحقق هدف اصلی پارادایم شئ‌گرا می شوند که تولید نرم‌افزار با کیفیت است. این اصول به ما کمک می‌کند که بهتر در مقابل تغییرات عمل کنیم و باعث راحت شدن نگهداری و تکامل سیستم می‌شود. با کمک این اصول می‌توانینم محصول با کیفیت تولید کنیم.
<br/>
در مرحله تحلیل اهمیت SOLID نهفته و پنهان است و نقش کمتری دارد. برای این مرحله لازم است که مدل تحلیل تا جای ممکن از انسجام کافی و وابستگی پایین (coupling کم داشته باشد) بهره ببرد. اما چون هدف اصلی مرحله تحلیل متفاوت است و جزئیات به قدر کافی مشخص نشده، نقش SOLID نیز کمتر است.
‌<br/>
در مرحله طراحی و پیاده سازی SOLID بسیار نقش مهمی دارند و برای تضمین طول عمر سیستم و تغییراتی که در طول ایجاد نرم‌افزار داریم لازم است. تنها با رعایت اصول SOLID است که می‌توانیم محصول با کیفیت پیاده سازی کنیم. امروزه در مهندسی نرم‌افزار تغییرات بخش جدا نشدنی هستند و در واقع تغییرات embrace می‌شوند. اعمال تغییرات در سیستم بدون رعایت این اصول می تواند منجر به بی‌کیفیتی و مرگ نرم‌افزار شود. در واقعی محصول به گونه ای طراحی و پیاده سازی ‌می‌شود که در آینده نگهداری از آن با کمترین مشکل رو به رو شود.
‌<br/>
در مرحله نگهداری و استقرار نیز باید از این اصول پیروی کرد و تغییرات را با توجه به آنها در محصول اعمال کرد تا کیفیت محصول از بین نرود.

### پرسش ۵
فرض کنید در آزمایش بالا نیازی به تغییر ابعاد مستطیل نداشتیم. آیا در این حالت می‌توانستیم مربع را از مستطیل به ارث ببریم؟ توضیح دهید.
### پاسخ:
با override کردن متود getArea و با توجه به تغییر نکردن مقادیر، امکان گرفتن نتیجه مطلوب را داریم. اما اینکار مناسب نیست. زیرا، در اینجا مربع فرزند مستطیل نیست، مستطیل مشخصات parent خود را ندارد. حالت پدر به دو متغیر طول و عرض وابسته است در حالی که در مربع، تنها به طول بستگی دارد (nature جداگانه دارند). در نتیجه مربع نمی‌تواند به درستی جانشین مستطیل باشد و اصل LSP نقض می‌شود. در نتیجه می‌توان به روش‌های دیگری عمل کرد (کلاس Shape که استفاده شده است). درست است که تغییر مقادیر در خروجی این مسئله خاص مشکلی ندارد، اما برای پیشگیری از اتفاقات آینده و افزایش عمر نرم‌افزار، باید به اصول شئ‌گرا عمل کرد.