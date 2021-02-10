# TestApplication
First Test of Android Studio, Concession Cashier Calculator

First Entry  
This one was more testing. I'm not sure if I'm supposed to be working on this yet, but it really made me more curious than anything else to work on.  
  
Honestly, in an IDE like Unity, this would be a cakewalk! I could have this whole idea done in a jiffy, but unfortunately we aren't using Unity nor C#, so it's difficult for me. In Unity, I would create what is called a "prefab," a prefabricated set of objects that I could instantiate or destroy quite easily with Instantiate() or Destroy(). In Android Studio, I don't think there is a such thing as a prefab. My searches for it did not dig up anything of the sort, at least. This left me questioning how to create new UI objects on the fly, setting IDs and such. What I found was pretty complex, and I wasn't thrilled, as creating a new menu item would take a ton of hard code anyway, sort of mitigating the reason as to why to not have it hardcoded in the first place. At some point in the next few weeks I plan on looking through this again and trying to develop this.  
  
My second biggest problem with it is having to connect the two activities on the fly, between Admin and General user. I don't have a second activity or a way to add new items, so this is all thinking about this abstractly. In my research, I found there was in fact a way to assign an ID programatically, but not a great way to connect two objects, like a TextView and an EditText. I tried a different method that I found, findViewByTag<T>(), but I could never get anything out of it aside from NULL. Oddly enough, I could never catch this NullReferenceException, but that could be because I'm not sure what the try-catch statement syntax is in Kotlin.  The idea for the findViewByTag<T>() would be to connect the TextView and it's respective EditText together through the tags, but I just could not get that working so I removed it.
  
I did try a new extension here, and that is java.text.NumberFormat. This was to format the final cost of the order. I also learned that a List<T> in Kotlin is really an Array, and a MutableList<T> is a List<T> in C#. I didn't notice this until I was trying to add a price to my priceList and found that there was no add() function for a List<T>. I also found out that you have to specifically state that a list should start as empty by calling mutableListOf(), instead of just creating a new empty list. I also used a TableLayout and TableRows to keep everything nice and organized. If I could just find a way to duplicate a tableRow then change attributes of it and its children, I'd solve my first issue.  
  
What I am most proud of with my work here is working around the whole no-variable thing with onClick attributes in XML. This I'm sort of used to, as Unity kind of had the same issues with it. In Unity, you're allowed to pass in one primitive parameter of your choosing. In Android Studio, that's chosen for you as a View object. I don't know exactly why Unity lets you, but my best guess is that there is already an EventSystem object that does all that work for you. To get around the no-or-one-variable block, you'd need to create a setOnClick method that creates a custom OnClickListener that calls an onClick method that calls a different method, like so:  
<pre>
    fun setOnClick(buttonId:Int, textId:Int, priceId: Int, isIncrease:Boolean)
    {
        val btn:Button = this.findViewById<Button>(buttonId)
        btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (isIncrease)
                    increaseAmount(v, textId, priceId)
                else
                    decreaseAmount(v, textId, priceId)
            }
        })
        if(!priceList.contains(textId))
            priceList.add(textId)
        if(!priceList.contains(priceId))
            priceList.add(priceId)
    }
 </pre>
 This I was comfortable with, as I've previously done something like this. It also goes to mention that Android Studio wanted to use a lambda expression, which is usually what I do in C#. I didn't want to do that because it affects the readability of the code to me, and I'm not the most comfortable with Kotlin anyway.  
  
Otherwise, everything else went about as planned. 
  
Second Entry  
2/10/2021   
With the addition of custom UI objects, I thought I would have it complete. But no, I kept getting KotlinNullPointerExceptions. I could not figure out how to get that fixed either. My method of catching the UI objects was to get all the children of the base LinearLayout and add those children into a MutableList of UpDownObjects. Now that I think about it, my code for getting the children might have been wrong, but I don't really see how that could have happened. I have since reverted the code and will go back for another swing at it later today. It's worth mentioning as well that I tried to make a TableRow custom object, but I couldn't get that working either, so I reverted it to a LinearLayout object again. 

I did, however, successfully change the updownbox, adding in two new TextViews. I'm not quite understanding the point of the <attr> though, they really didn't seem to do anything different when you could just declare them as a private var inside the class.  
  
AKA: Basically everything that I tried failed.
