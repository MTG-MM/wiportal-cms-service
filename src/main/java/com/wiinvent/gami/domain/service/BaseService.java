package com.wiinvent.gami.domain.service;

import com.wiinvent.gami.ModelMapper;
import com.wiinvent.gami.domain.stores.*;
import com.wiinvent.gami.domain.stores.transaction.*;
import com.wiinvent.gami.domain.stores.game.*;
import com.wiinvent.gami.domain.stores.gvc.GvcPackageStorage;
import com.wiinvent.gami.domain.stores.payment.PaymentMethodStorage;
import com.wiinvent.gami.domain.stores.payment.PackageHistoryStorage;
import com.wiinvent.gami.domain.stores.reward.*;
import com.wiinvent.gami.domain.stores.user.*;
import com.wiinvent.gami.domain.utils.CacheKey;
import com.wiinvent.gami.domain.utils.LockManager;
import com.wiinvent.gami.domain.utils.RemoteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService {
  @Autowired protected ModelMapper modelMapper;
  @Autowired protected RemoteCache remoteCache;
  @Autowired protected CacheKey cacheKey;
  @Autowired protected LockManager lockManager;
  @Autowired protected AccountStorage accountStorage;
  @Autowired protected ConfigStorage configStorage;
  @Autowired protected UserStorage userStorage;
  @Autowired protected UserSegmentStorage userSegmentStorage;
  @Autowired protected RewardItemHistoryStorage rewardItemHistoryStorage;
  @Autowired protected RewardItemStorage rewardItemStorage;
  @Autowired protected RewardScheduleStorage rewardScheduleStorage;
  @Autowired protected RewardSegmentDetailStorage rewardSegmentDetailStorage;
  @Autowired protected RewardSegmentStorage rewardSegmentStorage;
  @Autowired protected RewardStateStorage rewardStateStorage;
  @Autowired protected RewardStateLogStorage rewardStateLogStorage;
  @Autowired protected RewardTypeStorage rewardTypeStorage;
  @Autowired protected VoucherDetailStorage voucherDetailStorage;
  @Autowired protected ProductDetailStorage productDetailStorage;
  @Autowired protected RewardItemStoreStorage rewardItemStoreStorage;
  @Autowired protected RewardItemStatisticStorage rewardItemStatisticStorage;
  @Autowired protected GameLikeStorage gameLikeStorage;
  @Autowired protected GameStarStorage gameStarStorage;
  @Autowired protected GameStorage gameStorage;
  @Autowired protected GamePackageStorage gamePackageStorage;
  @Autowired protected GameCategoryStorage gameCategoryStorage;
  @Autowired protected PackageStorage packageStorage;
  @Autowired protected PaymentMethodStorage paymentMethodStorage;
  @Autowired protected PackageHistoryStorage packageHistoryStorage;
  @Autowired protected GamePaymentTransactionStorage gamePaymentTransactionStorage;
  @Autowired protected FriendStorage friendStorage;
  @Autowired protected UserNotifyStorage userNotifyStorage;
  @Autowired protected GameTypeStorage gameTypeStorage;
  @Autowired protected UserProfileStorage userProfileStorage;
  @Autowired protected CoinTransactionStorage coinTransactionStorage;
  @Autowired protected PointTransactionStorage pointTransactionStorage;
  @Autowired protected ExpHistoryStorage expHistoryStorage;
  @Autowired protected TurnTransactionStorage turnTransactionStorage;
  @Autowired protected GameTournamentStorage gameTournamentStorage;
  @Autowired protected GvcPackageStorage gvcPackageStorage;
  @Autowired protected CharacterStorage characterStorage;
  @Autowired protected GameTournamentUserStorage gameTournamentUserStorage;
  @Autowired protected GameTournamentEventStorage gameTournamentEventStorage;
  @Autowired protected UserAccountStorage userAccountStorage;
  @Autowired protected FeatureStorage featureStorage;
  @Autowired protected PackageTypeStorage packageTypeStorage;
  @Autowired protected BannerStorage bannerStorage;
  @Autowired protected CharacterUserTransactionStorage characterUserTransactionStorage;
  @Autowired protected AchievementStorage achievementStorage;
  @Autowired protected AchievementUserStorage achievementUserStorage;
  @Autowired protected SubStateStorage subStateStorage;
  @Autowired protected PremiumStateStorage premiumStateStorage;
  @Autowired protected ChallengeStorage challengeStorage;
  @Autowired protected ChallengeDetailStorage challengeDetailStorage;
  @Autowired protected CollectionStorage collectionStorage;
  @Autowired protected CollectionTransactionStorage collectionTransactionStorage;
  @Autowired protected TicketHistoryStorage ticketHistoryStorage;
  @Autowired protected UserCollectionStorage userCollectionStorage;
  @Autowired protected ExchangeItemStoreStorage exchangeItemStoreStorage;
  @Autowired protected LuckyPointTransactionStorage luckyPointTransactionStorage;
  @Autowired protected QuestStorage questStorage;
  @Autowired protected QuestTurnStorage questTurnStorage;
}
