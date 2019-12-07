
        function Switch(obj) {
            var div = document.getElementById(obj);
            if(div.style.backgroundColor === "#6DFC93"){
                div.style.backgroundColor = "#27D956";
            }else{
                div.style.backgroundColor = "#6DFC93";
            }

        }
        var myColors = ['red', 'purple', '#E84751', 'blue', 'orange', '#323643'];
                
        function clickMe(){
          var randomize = Math.floor(Math.random()*myColors.length);
          $('.box').css("background-color", myColors[randomize]);
        }