$(document).ready(function() {
  // jQuery(html [, ownerDocument])
  $('<p id = "test" > My <em> new </em> test</p>').appendTo(' body ');

  // jQuery(html, props)
  $("<div / > ", {
    "class": "test",
    text: "Click me",
    click: function() {
      $(this).toggleClass("test");
    }
  }).appendTo("body");

  // jQuery(element) jQuery(elementArray)
  $('div.foo').click(function() {
    $(this).slideup();
  });

  // jQuery(object)
  // 定义一个普通 Javascript 对象
  var foo = {
    foo: 'bar',
    hello: 'world'
  };
  // 封装成 jQuery 对象
  var $foo = $(foo);
  // 绑定一个事件
  $foo.on('custom', function() {
      console.log('custom event was called');
    })
    // 触发这个事件
  $foo.trigger('custom');
});
