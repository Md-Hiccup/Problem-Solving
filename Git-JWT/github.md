## Git Initial Command 
>   git init

>   git clone https://github.com/cooperka/emoji-commit-messages.git

>   git status

>   git branch <**new-branch-name**>

>   git checkout <**existing-branch-name**>     or      git checkout -b <**new-branch-name**>

>   git add <**files**>     or      git add -all      or      git add **Readme.md app/*.txt**

>   git commit -m "Add a new feature"

>   git push origin <**branch-name**>   or  git push origin HEAD

//   HEAD always refers to your latest checkpoint, that is, the latest commit on your current branch.

##  Some other commands 
>   git reflog      #   Reference Logs

>   git stash

>   git diff <**branch-name**> <**other-branch-name**>

>   git checkout -b <**new-branch-name**>

>   git add **Readme.md app/*.txt**

>   git add -all

>   git fetch       //  to fetch the latest info about a repo.

>   git merge <**other-branch-name**>

// git fetch && git merge

>   git checkout master  && git fetch  &&  git merge origin/master

    or

>   git pull origin master


## ********    REAL LIFE EXAMPLE   *********
>   git clone https://github.com/cooperka/emoji-commit-messages.git

>   cd emoji-commit-messages

>   git status

>   git checkout -b my-new-feature

>   echo “This is a cool new file” > my-file.txt

>   git status

>   git add --all

>   git status

>   git diff HEAD

>   git commit -m “Add my-file.txt”

>   git status

>   git log

>   git push origin HEAD

>   git checkout master

>   git pull



## ***** To see real life branch visualizations *****

>   $ git log --all --decorate --oneline --graph

>   $ git merge master

>   $ git rebase master


## ***** To Setting Global username and email *****
>   $ git config --global user.name "John Doe"

>   $ git config --global user.email johndoe@example.com


## ***** To reset origin to different url *****

>   $ git remote -v     // To view all the origin 
or
>   $ git config --get remote.origin.url

>   $ git remote set-url origin <*url*>
