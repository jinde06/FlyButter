package com.example.flybutter;

import java.util.Random;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint({ "DrawAllocation", "ClickableViewAccessibility" })
public class MainActivitygame extends Activity {

	Sexy sexy;
	private static int hscore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		sexy = new Sexy(this);
		setContentView(sexy);
	}

	public static int getHS() {
		return hscore;
	}

	public class Sexy extends View {

		Paint paint = new Paint();;
		float x, y, web1, web2, web3, web4, x1, x2, x3, x4, game, flap;
		int height, width, start, score;
		Random random = new Random();
		Bitmap bg, bfly, net1, net2;
		Paint txt = new Paint();
		Collision obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9;

		public Sexy(Context context) {
			super(context);
			x1 = x2 = x3 = x4 = -1;
			bg = BitmapFactory.decodeResource(getResources(),
					R.drawable.bckgrnd);
			bfly = BitmapFactory
					.decodeResource(getResources(), R.drawable.fbaa);
			net2 = BitmapFactory
					.decodeResource(getResources(), R.drawable.weba);
			net1 = BitmapFactory
					.decodeResource(getResources(), R.drawable.webb);
			score = 0;
		}

		int init = 0;

		public void resize() {
			bg = Bitmap.createScaledBitmap(bg, width, height, false);
			net1 = Bitmap.createScaledBitmap(net1, 200, 800, false);
			net2 = Bitmap.createScaledBitmap(net2, 200, 800, false);
			init++;
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			height = canvas.getHeight();
			width = canvas.getWidth();

			if (init == 0) {
				resize();
			}

			canvas.drawBitmap(bg, 0, 0, null);

			txt.setARGB(255, 255, 0, 0);
			txt.setTextAlign(Align.CENTER);
			txt.setTextSize(25);

			if (start == 0) {
				canvas.drawText("HS : " + hscore, canvas.getWidth() / 2,
						height / 8, txt);
				canvas.drawText("TAP TO START", canvas.getWidth() / 2,
						height / 4, txt);
				score = 0;
				game = 0;
			} else {
				if (score > hscore) {
					hscore = score;
				}

				canvas.drawText("Score : " + score, canvas.getWidth() / 2,
						height / 4, txt);

				if (flap > 0) {
					flap -= height * .02f;
					y -= height * .02f;
				}

				if (x1 < 0) {
					web1 = random.nextInt(height);
					if (web1 > height - (height * .4f)) {
						web1 -= height * .4f;
					}
					if (web1 < height * .1f) {
						web1 += height * .1f;
					}
					x1 = width * 2.4f;
					score++;
				}
				if (x2 < 0) {
					web2 = random.nextInt(height);
					if (web2 > height - (height * .4f)) {
						web2 -= height * .4f;
					}
					if (web2 < height * .1f) {
						web2 += height * .1f;
					}
					x2 = width * 2.4f;
					score++;
				}
				if (x3 < 0) {
					web3 = random.nextInt(height);
					if (web3 > height - (height * .4f)) {
						web3 -= height * .4f;
					}
					if (web3 < height * .1f) {
						web3 += height * .1f;
					}
					x3 = width * 2.4f;
					score++;
				}
				if (x4 < 0) {
					web4 = random.nextInt(height);
					if (web4 > height - (height * .4f)) {
						web4 -= height * .4f;
					}
					if (web4 < height * .1f) {
						web4 += height * .1f;
					}
					x4 = width * 2.4f;
					score++;
				}

				if (game == 0) {
					x1 = width * 1f;
					x2 = width * 1.6f;
					x3 = width * 2.2f;
					x4 = width * 2.8f;
					y = height * .25f;
					game = 1;
					score = 0;
				}

				paint.setColor(Color.GREEN);
				// canvas.drawRect(left, top, right, bottom, paint);
				// canvas.drawRect(x1--, 0, x1 + (width * .2f), web1, paint);
				// canvas.drawRect(x1, web1 + height * .3f, x1 + (width * .2f),
				// height, paint);
				canvas.drawBitmap(net1, x1 -= 3, web1 - 800, null);
				canvas.drawBitmap(net2, x1, web1 + height * .3f, null);

				// canvas.drawRect(x2--, 0, x2 + (width * .2f), web2, paint);
				// canvas.drawRect(x2, web2 + height * .3f, x2 + (width * .2f),
				// height, paint);
				canvas.drawBitmap(net1, x2 -= 3, web2 - 800, null);
				canvas.drawBitmap(net2, x2, web2 + height * .3f, null);

				// canvas.drawRect(x3--, 0, x3 + (width * .2f), web3, paint);
				// canvas.drawRect(x3, web3 + height * .3f, x3 + (width * .2f),
				// height, paint);
				canvas.drawBitmap(net1, x3 -= 3, web3 - 800, null);
				canvas.drawBitmap(net2, x3, web3 + height * .3f, null);

				// canvas.drawRect(x4--, 0, x4 + (width * .2f), web4, paint);
				// canvas.drawRect(x4, web4 + height * .3f, x4 + (width * .2f),
				// height, paint);
				canvas.drawBitmap(net1, x4 -= 3, web4 - 800, null);
				canvas.drawBitmap(net2, x4, web4 + height * .3f, null);

				paint.setARGB(255, 0, 0, 0);
				paint.setTextAlign(Align.CENTER);
				paint.setTextSize(25);

				canvas.drawText("Aina - Majo", width / 2, height * .1f, paint);
				canvas.drawText("Credit : RAC", width / 2, height * .75f, paint);

				if (y < 0) {
					y = width * .05f;
				}

				if (y > height) {
					game = 0;
				}
				paint.setColor(Color.RED);
				// canvas.drawCircle(width * .20f, y++, width * .05f, paint);
				canvas.drawBitmap(bfly, width * .20f, y += 5, null);

				obj1 = new Collision(width * .20f, y, bfly.getWidth(),
						bfly.getHeight());
				obj2 = new Collision(x1, web1 - 800, 200, 800);
				obj3 = new Collision(x1, web1 + height * .3f, 200, 800);
				obj4 = new Collision(x2, web2 - 800, 200, 800);
				obj5 = new Collision(x2, web2 + height * .3f, 200, 800);
				obj6 = new Collision(x3, web3 - 800, 200, 800);
				obj7 = new Collision(x3, web3 + height * .3f, 200, 800);
				obj8 = new Collision(x4, web4 - 800, 200, 800);
				obj9 = new Collision(x4, web4 + height * .3f, 200, 800);

				if (obj1.Rec(obj2) | obj1.Rec(obj3) | obj1.Rec(obj4)
						| obj1.Rec(obj5) | obj1.Rec(obj6) | obj1.Rec(obj7)
						| obj1.Rec(obj8) | obj1.Rec(obj9)) {
					start = 0;
				}

			}
			invalidate();
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				start++;
				flap = height * .15f;
				break;
			}
			invalidate();
			return true;

		}
	}

	public class Collision {
		public float x;
		public float y;
		public float width;
		public float height;
		public float radius;

		public Collision() {

		}

		public Collision(float x, float y, float width, float height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public Collision(float x, float y, float radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public Boolean Rec(Collision obj2) {
			if (this.x < obj2.x + obj2.width && this.x + this.width > obj2.x
					&& this.y < obj2.y + obj2.height
					&& this.y + this.height > obj2.y)
				return true;
			else
				return false;
		}

		public Boolean Cir(Collision obj2) {
			float distance = (this.x - obj2.x) * (this.x - obj2.x)
					+ (this.y - obj2.y) * (this.y - obj2.y);
			float radiusSum = this.radius + obj2.radius;
			return distance <= radiusSum * radiusSum;
		}

		public Boolean RecCir(Collision obj2) {
			float closestX = obj2.x;
			float closestY = obj2.y;
			if (obj2.x < this.x) {
				closestX = this.x;
			} else if (obj2.x > this.x + this.width) {
				closestX = this.x + this.width;
			}
			if (obj2.y < this.y) {
				closestY = this.y;
			} else if (obj2.y > this.y + this.height) {
				closestY = this.y + this.height;
			}
			float distX = (closestX - obj2.x) * (closestX - obj2.x);
			float distY = (closestY - obj2.y) * (closestY - obj2.y);
			return distX + distY < obj2.radius * obj2.radius;
		}

	}

}
