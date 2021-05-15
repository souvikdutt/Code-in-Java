package code.with.souvik;

import java.util.*;

public class SongShuffler {
	//Array is used to store the songs
	private String[] playlist;
	//This variable is used to keep track of pending songs
	private int pendingLotEndPoint;
	//Creating an object of Random to generate random numbers
	private Random random = new Random();
	
	//Constructor to initialize the playlist and pending lot
	public SongShuffler(String[] playlist) {
		this.playlist = playlist;
		//Initially all the songs are unplayed and so it will
		//be outside of the array for now
		this.pendingLotEndPoint = playlist.length;
	}
	
	public String playRandomSong() {
		int songToReturnIdx;
		String songToReturn;
		//This will return an index from (0 to pendingLotEndPoint-1)
		//(0 to PLEP-1) ---> pending lot ---> It will keep Shrinking
		//(PLEP to playlist.length) ---> Played songs ---> Keep growing
		songToReturnIdx = random.nextInt(pendingLotEndPoint);
		songToReturn = playlist[songToReturnIdx];
		
		//Putting the song at the rear end so that it can be removed 
		//from future considerations
		swap(songToReturnIdx,pendingLotEndPoint-1);
		//Shrinking the index pool from where we want to run our random generator
		pendingLotEndPoint--;
		
		//All the songs have been played. So, we have to reset the pending lot
		if(pendingLotEndPoint == 0) {
			pendingLotEndPoint = playlist.length;
		}
		//Return the song Id which is to be played next
		return songToReturn;
	}
	
	private void swap(int i,int j) {
		if(i == j) return;
		
		String temp = playlist[i];
		playlist[i] = playlist[j];
		playlist[j] = temp;
	}
	
	public static void main(String[] args) {
		String[] songs = {"Shivay","Shree Krishna Govind","Tomake Chuye Dilam","Main Zindegi ka geet","Ae watan","Tose Naina"};
		SongShuffler songShuffler = new SongShuffler(songs);
		
		System.out.println("Iteration 1");
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		
		System.out.println("Iteration 2");
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
		System.out.println("Next song: "+songShuffler.playRandomSong());
	}
	
}
