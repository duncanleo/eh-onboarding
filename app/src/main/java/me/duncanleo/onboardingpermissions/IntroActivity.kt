package me.duncanleo.onboardingpermissions

import android.Manifest
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntroFragment


class IntroActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        askForPermissions(arrayOf(Manifest.permission.CAMERA), 1)
        askForPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)
        askForPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 3)
        askForPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), 4)

        addSlide(AppIntroFragment.newInstance("Permissions", "We need your camera!", R.drawable.ic_camera_alt_white_24dp, Color.parseColor("#00BCD4")))
        addSlide(AppIntroFragment.newInstance("Permissions (cont'd)", "We need your location!", R.drawable.ic_location_on_white_24dp, Color.parseColor("#4DAF50")))
        addSlide(AppIntroFragment.newInstance("Permissions (cont'd)", "We need your contacts!", R.drawable.ic_contact_phone_white_24dp, Color.parseColor("#F99401")))
        addSlide(AppIntroFragment.newInstance("Permissions (cont'd)", "We need your storage!", R.drawable.ic_sd_storage_white_24dp, Color.parseColor("#222222")))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        finish()
    }
}
