##   instal python 3 and apscheduler 3.3.1

import requests, os, bs4 #webbrowser, subprocess, pprint
import datetime, time ,sys
from apscheduler.schedulers.background import BackgroundScheduler

i = 0

def downloadImg(soup, scheduler):
    global i 
    #Find the url of the img   
    print('inside download img')
    url = soup.select('figure div._1Nk0C a')
    # print(Img)
    print(len(url))

    if i == 20:
        print('stop')
        scheduler.remove_job('download_Image')
        sys.exit()
    
    wallpaper = url[i].get('href')
    print(wallpaper)
    name = (str(i)+'.jpg')
    print('Downloading.....'+ name)
    res = requests.get(wallpaper)
    res.raise_for_status()
    imageFile = open(os.path.join('wall', name ),'wb')
    for chunk in res.iter_content(100000):
        imageFile.write(chunk)
    imageFile.close()
    setWallpaper(name)
    i= i+1
       

def setWallpaper(pic):
    home = os.getenv('HOME')
    path = home + '/Desktop/'
    desktop_path = '/usr/bin/gsettings set org.gnome.desktop.background picture-uri '
    
    print('inside setWallpaper')
    os.chdir(path+'wall')
    file = 'file://' + path + 'wall/' + pic
    print(file)
    os.system(desktop_path+file)
    os.chdir(path)


def main():
    home = os.getenv('HOME')
    path = home + '/Desktop/'
    url = 'https://unsplash.com/search/photos/wallpaper' # starting url
    if sys.version_info[0] < 3:
        raise "Must be using Python 3"
    else :
        os.chdir(path) 
        os.makedirs('wall', exist_ok=True) # store imgaes in ./wall
        res = requests.get(url)
        res.raise_for_status()
        soup = bs4.BeautifulSoup(res.text, 'lxml')
        scheduler = BackgroundScheduler()
        scheduler.add_job(downloadImg, 'interval', seconds=2, args=[soup, scheduler], id='download_Image')
       # dt = datetime.datetime.now();
        scheduler.start()
        print('Press Ctrl+{0} to exit'.format('Break' if os.name == 'nt' else 'C'))
        try:
            # This is here to simulate application activity (which keeps the main thread alive).
            while True:
                time.sleep(10)
        except (KeyboardInterrupt, SystemExit):
            # Not strictly necessary if daemonic mode is enabled but should be done if possible
            scheduler.shutdown()
        print('Done')


if __name__ == '__main__':
    main()