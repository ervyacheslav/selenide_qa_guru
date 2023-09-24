# selenide_qa_guru

$("h1 div") ищет div внутри любого h1
$("h1").$("div") ищет div внутри первого h1



<h1>Hello World</h1>
<h1><div>Bye World</div></h1>
$("h1").$("div"), ничего не найдет т.к. будет искать div первом h1
