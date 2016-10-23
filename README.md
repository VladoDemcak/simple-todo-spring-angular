This is simple description of TODO system.

System consists of two parts.

## Part 1.

FRONT END - angularjs client. THere are used 2 controllers and 2 views. One for login form an checking or registering new user.
I have used bootstrap for mobile first technique and third side scripts are stored on other servers.

## Part 2.
BACK END is build on spring framework. Backend provides REST api for creating new TODO task, mark task as done or retrieving tasks for specific user.

Because of time limitations system does not use any database. So this is the reason why every restart of server will delete all data.

Backend supports maven (pom.xml) file for compiling and creating war file, which is deployed on server (http://app.demcak.net/demcak_todo_backend-1)

REsources:
OK ICON - http://www.softicons.com/toolbar-icons/flat-2013-toolbar-icons-by-aha-soft/ok-icon 

------

## License
    The MIT License (MIT)
    
    Copyright (c) <year> <copyright holders>

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.